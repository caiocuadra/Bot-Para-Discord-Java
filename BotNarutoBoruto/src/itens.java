
public class itens {
	public String[] itensDeAtaque = 
		{
				"***Kunai Explosiva Avançada***",
				"***Shuriken Bumerangue***",
				"**Senbon Envenenado**",
				"**Senbon**",
				"**Fio de Aço**"
		};
	public String[] getDescricaoItensDeAtaque() {
		return descricaoItensDeAtaque;
	}
	public String[] getDescricaoItensDeDefesa() {
		return descricaoItensDeDefesa;
	}
	public String[] getItensDeAtaque() {
		return itensDeAtaque;
	}
	public void setItensDeAtaque(String[] itensDeAtaque) {
		this.itensDeAtaque = itensDeAtaque;
	}
	public String[] getItensDeDefesa() {
		return itensDeDefesa;
	}
	public void setItensDeDefesa(String[] itensDeDefesa) {
		this.itensDeDefesa = itensDeDefesa;
	}
	public int[] getValorItensAtaque() {
		return valorItensAtaque;
	}
	public int[] getValorItensDefesa() {
		return valorItensDefesa;
	}

	public String[] descricaoItensDeAtaque = 
		{
				"Kunai equipada com um selo de explosão de alto alcance. Ideal para combates em campo aberto.",
				"Shuriken que retorna ao usuário com o uso de chakra.",
				"Agulhas com toxinas paralisantes.",
				"Agulhas super afiadas que perfuram seu inimigo.",
				"O fio de aço pode ser usado como condutor de chakra de fogo, permitindo que o usuário canalize Katon pelo fio."
		};
	public String[] efeitosItensDeAtaque = 
		{
				"Causa dano em área, queimaduras leves.",
				"Pode atingir o inimigo duas vezes.",
				"Dano leve + chance de paralisar.",
				"Pode ser usado 5 por turno.",
				"Paralisa o oponente"
		};
	public int[] valorItensAtaque = 
		{
			200,
			300,
			40,
			10,
			30
		};
	public String retornaItensDeAtaque() 
	{
		String itens = "***1. Kunai Explosiva Avançada*** **$200**\n"
				+ "*(Kunai equipada com um selo de explosão de alto alcance. Ideal para combates em campo aberto.)*\n***2. Shuriken Bumerangue*** **$300**\n]"
				+ "*(Shuriken que retorna ao usuário com o uso de chakra.)*\n**3. Senbon Envenenado** **$40**\n"
				+ "*(Agulhas com toxinas paralisantes.)*\n**4. Senbon** **$10**\n"
				+ "*(Agulhas super afiadas que perfuram seu inimigo.)\n**5. Fio de Aço** **$30**\n*"
				+ "*(O fio de aço pode ser usado como condutor de chakra de fogo, permitindo que o usuário canalize Katon pelo fio.)*\n\n";
		return itens;
	}
	
	//agora itens de defesa
	
	public String[] itensDeDefesa = 
		{
				"***Pílula de Soldado (Soldier Pill)***",
				"***Pomada de Cura Rápida***",
				"***Essência de Flor de Lótus Branca***"
		};
	public String[] descricaoItensDeDefesa = 
		{
				"Restaura chakra, usada por ninjas em campo.",
				"Aplicação externa que cicatriza cortes e queimaduras.",
				"Elixir raro, cura venenos e tira efeitos negativos."
		};
	public String[] efeitosItensDeDefesa = 
		{
				"+50% de chakra total. 1 por batalha!!",
				"Recupera ferimentos leves/médios. (Recupera 20% se sua vida estiver acima de 50% e recupera 40% se sua vida estiver abaixo de 30%) Pode ser usado 1 por batalha!!",
				"Remove status negativos. "
		};
	public int[] valorItensDefesa = 
		{
			250,
			230,
			200
		};
	public String retornaItensDeDefesa() 
	{
		String itens = "***6. Pílula de Soldado (Soldier Pill)*** **$250**\n"
				+ "*(Restaura chakra, usada por ninjas em campo.)*\n***7. Pomada de Cura Rápida*** **$230**\n]"
				+ "*(Aplicação externa que cicatriza cortes e queimaduras.)*\n*8. Essência de Flor de Lótus Branca* **$200**\n"
				+ "*(Elixir raro, cura venenos e tira efeitos negativos.)*\n";
		return itens;
	}
}
