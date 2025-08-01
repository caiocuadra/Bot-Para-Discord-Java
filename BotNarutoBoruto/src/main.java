import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class main {

	public static void main(String[] args) throws InterruptedException 
	{
		String TOKEN = ""; //token do bot
		
		JDABuilder construtor = JDABuilder.createDefault(TOKEN);
			construtor.addEventListeners(new MeuBot());
			construtor.enableIntents(GatewayIntent.MESSAGE_CONTENT);
			
		JDA jda = construtor.build();
		jda.awaitReady();
		System.out.println("Bot iniciado com sucesso.");
		
		String guildId = ""; //id do servidor
		
		Guild guild = jda.getGuildById(guildId);
		
		if(guild != null) 
		{
			
			guild.updateCommands().addCommands(
					Commands.slash("roll-normal", "🎲 Sorteia 1 clã aleatório"),
					Commands.slash("roll-vip", "💎 Sorteia 1 de 3 clãs aleatórios escolhidos. (VIP)")
						.addOptions(
						 new OptionData(OptionType.STRING, "clan1", "Primeiro Clã escolhido.", true),
						 new OptionData(OptionType.STRING, "clan2", "Segundo Clã escolhido.", true),
						 new OptionData(OptionType.STRING, "clan3", "Terceiro Clã escolhido.", true)
						),
					Commands.slash("lootbox", "🎲 Abra a sua Lootbox e ganhe itens especiais!")
						.addOption(OptionType.STRING, "tipo", "Tipo da lootbox (normal, rara ou lendária)", true),
					Commands.slash("roll-bijuu", "🎲 Sorteia 1 bijuu"),
					Commands.slash("roll-prodigio", "🎲 Tente despertar como prodígio!"),
					Commands.slash("roll-caixa", "🎲 Sorteia 1 item da caixa escolhida.")
						.addOption(OptionType.STRING, "tipo", "Tipo da caixa (azul, vermelha ou dourada)", true),
					Commands.slash("comprar", "Compre um ou mais itens da loja!")
					.addOptions(
							 new OptionData(OptionType.STRING, "item", "Primeiro Clã escolhido.", true),
							 new OptionData(OptionType.STRING, "quantidade", "Segundo Clã escolhido.", true)
							),
					Commands.slash("ver-inventario", "Veja os itens que estão no seu inventário!"),
					Commands.slash("minerar", "Que tal trabalhar minerando e ganhar $?"),
					Commands.slash("ferreiro", "Agora você pode forjar armas com seus minérios!")
				    .addOption(OptionType.STRING, "tipo", "Tipo do minério", true),
				    Commands.slash("ver-saldo", "Veja quanto você tem na carteira!")
			).queue();
			System.out.println("Comandos adicionados com sucesso.");
		}
		if(guild == null) {
			System.out.println("Servidor não encontrado.");
		}

	}

}

class MeuBot extends ListenerAdapter
{
	private final Map<Long, Long> cooldowns = new HashMap<>();
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private final long COOLDOWN_MILIS = 3 * 60 * 60 * 1000; // 3 horas
	private final Map<Long, Long> ferreiroCooldowns = new HashMap<>();
	
	class ArmaInfo {
	    int tempoHoras;
	    int poder;
	    String nome;
	    String tipoMinerio;
	    int quantidadeNecessaria;

	    ArmaInfo(int tempoHoras, int poder, String nome, String tipoMinerio, int quantidadeNecessaria) {
	        this.tempoHoras = tempoHoras;
	        this.poder = poder;
	        this.nome = nome;
	        this.tipoMinerio = tipoMinerio;
	        this.quantidadeNecessaria = quantidadeNecessaria;
	    }
	}
	
	
	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) 
	{
		switch (event.getName()) 
		{
			case "roll-normal" -> 
				{
					Clans clans = new Clans(); //Instanciar a classe Clans (obtem os clans e os gifs)
					String[] arrayClans = clans.getClans(); //obtem o array dos Clas
					String[] arrayGifsClans = clans.getGifClans(); //obtem o array dos gifs
					Random aleatorio = new Random(); //Instanciar a classe Random na variavel "aleatorio"
					int indiceAleatorio = aleatorio.nextInt(arrayClans.length); //cria o int do indice
					String clanEscolhido = arrayClans[indiceAleatorio];
					String gifDoClanEscolhido = arrayGifsClans[indiceAleatorio];
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Clã Sorteado:");
					embed.setDescription("**"+clanEscolhido+"**");
					embed.setImage(gifDoClanEscolhido);
					event.replyEmbeds(embed.build()).queue();
				}
			case "roll-vip" ->
				{
					String clan1 = event.getOption("clan1") != null 
		                ? event.getOption("clan1").getAsString()
		                : event.getUser().getName(); // fallback se não passar
					String clan2 = event.getOption("clan2") != null
						? event.getOption("clan2").getAsString()
						: event.getUser().getName();
					String clan3 = event.getOption("clan3") != null
						? event.getOption("clan3").getAsString()
						: event.getUser().getName();
					
					Random aleatorio = new Random();
					int indiceAleatorio = aleatorio.nextInt(3);
					
					if(indiceAleatorio == 0)
					{
						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("🎯 Clã Sorteado:");
						embed.setDescription("**"+clan1+"**");
						embed.setImage("https://giffiles.alphacoders.com/219/219784.gif");
						event.replyEmbeds(embed.build()).queue();
					}
					if(indiceAleatorio == 1)
					{
						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("🎯 Clã Sorteado:");
						embed.setDescription("**"+clan2+"**");
						embed.setImage("https://giffiles.alphacoders.com/219/219784.gif");
						event.replyEmbeds(embed.build()).queue();
					}
					if(indiceAleatorio == 2)
					{
						EmbedBuilder embed = new EmbedBuilder();
						embed.setTitle("🎯 Clã Sorteado:");
						embed.setDescription("**"+clan3+"**");
						embed.setImage("https://giffiles.alphacoders.com/219/219784.gif");
						event.replyEmbeds(embed.build()).queue();
					}
				}
			case "lootbox" ->
			{
				String tipo = event.getOption("tipo") != null 
	                ? event.getOption("tipo").getAsString()
	                : event.getUser().getName(); // fallback se não passar
				
				if(tipo.equals("normal")) 
				{
					LootboxNormal lootbox = new LootboxNormal();
					String item = lootbox.sorteiaLootbox("normal");
					String[] itens = lootbox.getLootBoxNormal();
					int indice = -1;
			        for (int i = 0; i < itens.length; i++) {
			            if (itens[i].equals(item)) {
			                indice = i;
			                break;
			            }
			        }
			        if (indice != -1) {
			            System.out.println("Índice encontrado: " + indice);
			        } else {
			            System.out.println("Valor não encontrado.");
			        }
			        String[] gifs = lootbox.getLootBoxNormalGif();
			        String gif = gifs[indice];
					
			        EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Item Sorteado:");
					embed.setDescription("Você abriu a Lootbox normal e ganhou: **"+item+"**");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
				if(tipo.equals("rara")) 
				{
					LootboxNormal lootbox = new LootboxNormal();
					String item = lootbox.sorteiaLootbox("rara");
					String[] itens = lootbox.getLootBoxRara();
					int indice = -1;
			        for (int i = 0; i < itens.length; i++) {
			            if (itens[i].equals(item)) {
			                indice = i;
			                break;
			            }
			        }
			        if (indice != -1) {
			            System.out.println("Índice encontrado: " + indice);
			        } else {
			            System.out.println("Valor não encontrado.");
			        }
			        String[] gifs = lootbox.getLootBoxRaraGif();
			        String gif = gifs[indice];
					
			        EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Item Sorteado:");
					embed.setDescription("Você abriu a **Lootbox** Rara e ganhou: **"+item+"**");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
				if(tipo.equals("lendaria")) 
				{
					LootboxNormal lootbox = new LootboxNormal();
					String item = lootbox.sorteiaLootbox("lendaria");
					String[] itens = lootbox.getLootBoxLendaria();
					int indice = -1;
			        for (int i = 0; i < itens.length; i++) {
			            if (itens[i].equals(item)) {
			                indice = i;
			                break;
			            }
			        }
			        if (indice != -1) {
			            System.out.println("Índice encontrado: " + indice);
			        } else {
			            System.out.println("Valor não encontrado.");
			        }
			        String[] gifs = lootbox.getLootBoxLendariaGif();
			        String gif = gifs[indice];
					
			        EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Item Sorteado:");
					embed.setDescription("Você abriu a Lootbox ***Lendária*** e ganhou: **"+item+"**");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
			}
			case "roll-bijuu" -> 
			{
				bijuus bijuu = new bijuus();
				String bijuuSorteada = bijuu.sorteiaBijuu();
				String gifBijuuSorteada = bijuu.getGif();
				
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("🎯 Bijuu Sorteada:");
				embed.setDescription("Parabéns! Você conseguiu a **"+bijuuSorteada+"**!");
				embed.setImage(gifBijuuSorteada);
				event.replyEmbeds(embed.build()).queue();
			}
			case "roll-prodigio" ->
			{
				Random indiceProdigio = new Random();
				int indiceAleatorioProdigio = indiceProdigio.nextInt(2);
				
				if(indiceAleatorioProdigio == 0) 
				{
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Prodígio Sorteado:");
					embed.setDescription("**Você ainda não mostrou sinais de prodígio... Continue tentando!**");
					embed.setImage("https://64.media.tumblr.com/73259fddd0945cbff90ff82dab633723/39c8d1d0a0835079-23/s540x810/f5b0a9e20a7720c7dab389f603851101132cabc6.gif");
					event.replyEmbeds(embed.build()).queue();
				}
				
				if(indiceAleatorioProdigio == 1) 
				{
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Prodígio Sorteado:");
					embed.setDescription("***Parabéns! Você despertou como prodígio!***");
					embed.setImage("https://giffiles.alphacoders.com/219/219665.gif");
					event.replyEmbeds(embed.build()).queue();
				}
			}
			case "roll-caixa" ->
			{
				String tipo = event.getOption("tipo") != null 
	                ? event.getOption("tipo").getAsString()
	                : event.getUser().getName(); // fallback se não passar
				
				if(tipo.equals("azul")) 
				{
					caixas cx = new caixas();
					String item = cx.sorteiaCaixaAzul();
					String gif = cx.getGif();
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Caixa Sorteada:");
					embed.setDescription("Parabéns! Você ganhou: ***"+item+"***");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
				if(tipo.equals("vermelha")) 
				{
					caixas cx = new caixas();
					String item = cx.sorteiaCaixaVermelha();
					String gif = cx.getGif();
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Caixa Sorteada:");
					embed.setDescription("Parabéns! Você ganhou: ***"+item+"***");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
				if(tipo.equals("dourada")) 
				{
					caixas cx = new caixas();
					String item = cx.sorteiaCaixaDourada();
					String gif = cx.getGif();
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setTitle("🎯 Caixa Sorteada:");
					embed.setDescription("Parabéns! Você ganhou: ***"+item+"***");
					embed.setImage(gif);
					event.replyEmbeds(embed.build()).queue();
				}
			}
			case "comprar" ->
			{
				int item = event.getOption("item") != null 
		                ? event.getOption("item").getAsInt()
		                : 1; // fallback se não passar
				int quantidade = event.getOption("tipo") != null 
		                ? event.getOption("tipo").getAsInt()
		                : 1; // fallback se não passar
				
				long userId = event.getUser().getIdLong();
				Inventario inv = new Inventario(userId);
				Saldo sd = new Saldo(userId);
				
				inv.verificaSaldoParaCompra(sd.getSaldo(), item, quantidade);
				
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Resultado da Transação:");
				embed.setDescription("**"+inv.getTransacao()+"**");
				event.replyEmbeds(embed.build()).queue();
			}
			case "ver-inventario" ->
			{
				long userId = event.getUser().getIdLong();
				Inventario inv = inventarioUtils.carregarInventario(userId);
				StringBuilder resposta = new StringBuilder("Seu inventário:\n");
				
				if(inv.getItens().isEmpty()) {
					resposta.append("-> Inventário vazio.");
				}else {
					for(Entry<String, Integer> item : inv.getItens().entrySet()) {
						resposta.append("-> ").append(item.getKey()).append(": ").append(item.getValue()).append("\n");
						
					}
				}
				
				event.reply(resposta.toString()).queue();
			}
			case "minerar" ->
			{
				
				long userId = event.getUser().getIdLong();
			    long agora = System.currentTimeMillis();
			    long ultimoUso = cooldowns.getOrDefault(userId, 0L);
			    long tempoRestante = COOLDOWN_MILIS - (agora - ultimoUso);

			    if (tempoRestante > 0) {
			        long minutos = tempoRestante / 1000 / 60;
			        event.reply("⏳ Você já minerou! Tente novamente em **" + minutos + " minutos**.")
			             .setEphemeral(true).queue();
			        return;
			    }

			    // Registra o uso
			    cooldowns.put(userId, agora);

			    // Informa que começou a minerar
			    event.reply("⛏️ Você começou a minerar! O resultado chegará em 3 horas via DM.")
			         .setEphemeral(true).queue();

			    // Simula mineração
			    Random rand = new Random();
			    Map<String, Integer> minerios = new HashMap<>();
			    Inventario inv = new Inventario(userId);
			    for (int i = 0; i < 5; i++) {
			        int indiceAleatorio = rand.nextInt(1001); // 0 a 1000

			        if (indiceAleatorio <= 600) {
			            minerios.put("Ferro", minerios.getOrDefault("Ferro", 0) + 1);
			            
			            inv.adicionarItem("Ferro", 1);
			        } else if (indiceAleatorio <= 800) {
			            minerios.put("Nióbio", minerios.getOrDefault("Nióbio", 0) + 1);
;
			            inv.adicionarItem("Nióbio", 1);
			        } else if (indiceAleatorio <= 950) {
			            minerios.put("Tungstênio", minerios.getOrDefault("Tungstênio", 0) + 1);
			            inv.adicionarItem("Tungstênio", 1);
			        } else {
			            minerios.put("Titânio", minerios.getOrDefault("Titânio", 0) + 1);
			            inv.adicionarItem("Titânio", 1);
			        }
			    }
			    
			    inventarioUtils invu = new inventarioUtils();
	            

			    // Agenda o envio do resultado após 3 horas
			    scheduler.schedule(() -> {
			    	invu.salvarInventario(inv);
			        StringBuilder resposta = new StringBuilder("💎 Resultado da Mineração:\n\n");

			        if (minerios.isEmpty()) {
			            resposta.append("-> Ocorreu um erro.");
			        } else {
			            for (Map.Entry<String, Integer> item : minerios.entrySet()) {
			                resposta.append("→ ").append(item.getKey())
			                        .append(": ").append(item.getValue()).append("\n");
			            }
			        }

			        // Envia como DM
			        event.getUser().openPrivateChannel().queue(channel -> {
			            channel.sendMessage(resposta.toString()).queue();
			        });

			    }, 3, TimeUnit.HOURS);
			}
			case "ferreiro" -> {
			    long userId = event.getUser().getIdLong();
			    long agora = System.currentTimeMillis();

			    String tipo = event.getOption("tipo").getAsString().toLowerCase();

			    
			    
			    // Map com os dados de cada minério
			    Map<String, ArmaInfo> tiposArmas = Map.of(
			    	    "ferro", new ArmaInfo(4, 90, "Arma de Ferro", "Ferro", 6),
			    	    "nióbio", new ArmaInfo(6, 135, "Arma de Nióbio", "Nióbio", 5),
			    	    "tungstênio", new ArmaInfo(8, 225, "Arma de Tungstênio", "Tungstênio", 4),
			    	    "titânio", new ArmaInfo(10, 270, "Arma de Titânio", "Titânio", 3)
			    	);

			    if (!tiposArmas.containsKey(tipo)) {
			        event.reply("❌ Tipo inválido. Escolha entre: Ferro, Nióbio, Tungstênio ou Titânio.")
			             .setEphemeral(true).queue();
			        return;
			    }

			    ArmaInfo arma = tiposArmas.get(tipo);
			    long cooldownMilis = arma.tempoHoras * 60L * 60L * 1000L;
			    long ultimoUso = ferreiroCooldowns.getOrDefault(userId, 0L);
			    long tempoRestante = cooldownMilis - (agora - ultimoUso);

			    if (tempoRestante > 0) {
			        long minutos = tempoRestante / 1000 / 60;
			        event.reply("⏳ Você já está forjando uma arma! Tente novamente em **" + minutos + " minutos**.")
			             .setEphemeral(true).queue();
			        return;
			    }
			    
			    // Carrega o inventário
			    Inventario inv = inventarioUtils.carregarInventario(userId);

			    // Verifica se tem minério suficiente
			    int quantidade = inv.getItens().getOrDefault(arma.tipoMinerio, 0);
			    if (quantidade < arma.quantidadeNecessaria) {
			        event.reply("❌ Você precisa de " + arma.quantidadeNecessaria + "x " + arma.tipoMinerio +
			                    " para forjar " + arma.nome + ". Você só tem " + quantidade + ".")
			             .setEphemeral(true).queue();
			        return;
			    }

			    // Remove os minérios do inventário
			    inv.removerItem(arma.tipoMinerio, arma.quantidadeNecessaria);
			    inventarioUtils.salvarInventario(inv);

			    // Registra o uso
			    ferreiroCooldowns.put(userId, agora);
			    event.reply("🔨 Você começou a trabalhar na sua " + arma.nome + 
			                "! E você terminará em " + arma.tempoHoras + " horas.")
			         .setEphemeral(true).queue();
			    
			    Saldo sd = new Saldo(userId);
			    

			    // Agenda entrega
			    scheduler.schedule(() -> {
			    	sd.adicionar(arma.poder);
			        String resultado = "🏹 Sua " + arma.nome + " foi forjada e vendida com sucesso!\n";

			        event.getUser().openPrivateChannel().queue(channel -> {
			            channel.sendMessage(resultado).queue();
			        });

			    }, arma.tempoHoras, TimeUnit.HOURS);
			}
			case "ver-saldo" ->
			{
				long userId = event.getUser().getIdLong();
				Saldo sd = new Saldo(userId);
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Seu saldo:");
				embed.setDescription("Seu saldo é: "+sd.getSaldo());
				event.replyEmbeds(embed.build()).queue();
			}
		}
		
	}
}












