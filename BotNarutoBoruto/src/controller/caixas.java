package controller;
import java.util.Random;

public class caixas {
	public String gif;
	public String sorteiaCaixaAzul() {
		Random rand = new Random();
		String item = null;
		int indice = rand.nextInt(1001);
		if(indice <= 300) 
		{
			item = "Luva Ninja";
			this.gif = "https://th.bing.com/th/id/OIP.1ARIEy24YUfh-X4AzfE-bwHaEK?w=258&h=180&c=7&r=0&o=7&pid=1.7&rm=3";
		}
		if(indice >= 300 && indice <= 600) 
		{
			item = "Bota Ninja";
			this.gif = "https://criticalhits.com.br/wp-content/uploads/2022/01/Rock-Lee-Removing-Weights.jpg";
		}
		if(indice >= 600 && indice <= 900) 
		{
			item = "Roupão Ninja";
			this.gif = "https://static.wikia.nocookie.net/liberproeliis/images/b/b0/Itachi_render_by_xuzumaki-d49n7va.png/revision/latest?cb=20161119225550&path-prefix=pt-br";
		}
		if(indice >= 900 && indice <= 950) 
		{
			item = "Luva Samurai (Rasgada)";
			this.gif = "https://wallpapers.com/images/featured/imagens-de-naruto-e5m4ji8p37fufudc.jpg";
		}
		if(indice >= 950 && indice <= 975) 
		{
			item = "Bota Samurai (Rasgada)";
			this.gif = "https://static.wikia.nocookie.net/anicrossbr/images/f/f8/Might_guy_by_otonaya-d7faaa4.png/revision/latest?cb=20151020145957&path-prefix=pt-br";
		}
		if(indice >= 975 && indice <= 1000) 
		{
			item = "Armadura Samurai(danificada)";
			this.gif = "https://static.wikia.nocookie.net/naruto/images/5/50/O_poder_de_Madara.png/revision/latest/scale-to-width-down/985?cb=20131003202911&path-prefix=pt-br";
		}

		return item;
	}
	public String sorteiaCaixaVermelha() {
		Random rand = new Random();
		String item = null;
		int indice = rand.nextInt(1001);
		if(indice <= 200) 
		{
			item = "Peitoral Senju(azul)";
			this.gif = "https://static.wikia.nocookie.net/liberproeliis/images/d/d1/980490be7a43335596810223e86dba8e.png/revision/latest?cb=20180710002944&path-prefix=pt-br";
		}
		if(indice >= 200 && indice <= 400) 
		{
			item = "Peitoral Senju(vermelho)";
			this.gif = "https://static.wikia.nocookie.net/anicrossbr/images/8/89/Hashirama2.png/revision/latest?cb=20151021121447&path-prefix=pt-br";
		}
		if(indice >= 400 && indice <= 600) 
		{
			item = "Peitoral Uchiha(Azul)";
			this.gif = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJx-d2_Ux5XsR_PAkCFLUexq7XwbwapwIO5g&s";
		}
		if(indice >= 600 && indice <= 800) 
		{
			item = "Peitoral Uchiha(Vermelho)";
			this.gif = "https://i.pinimg.com/736x/11/46/54/114654efd2169c3ad5992c5df959dcef.jpg";
		}
		if(indice >= 800 && indice <= 900) 
		{
			item = "Botas Uchiha/Senju";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400379964599304323/desktop-wallpaper-naruto-uchiha-madara-senju-hashirama-black-shirt-fire-uchiha-madara-vs-hashirama-senju.png?ex=688c6cf9&is=688b1b79&hm=68f9264ccfe6e48358d23b4c055be43cd98f75648a57b6195beef622caaa2af3&";
		}
		if(indice >= 900 && indice <= 1000) 
		{
			item = "Luvas Uchiha/Senju";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400379964599304323/desktop-wallpaper-naruto-uchiha-madara-senju-hashirama-black-shirt-fire-uchiha-madara-vs-hashirama-senju.png?ex=688c6cf9&is=688b1b79&hm=68f9264ccfe6e48358d23b4c055be43cd98f75648a57b6195beef622caaa2af3&";
		}

		return item;
	}
	public String sorteiaCaixaDourada() {
		Random rand = new Random();
		String item = null;
		int indice = rand.nextInt(1001);
		if(indice <= 300) 
		{
			item = "Armadura Completa Samurai";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400370930366025729/gGYi8adyl9bOYbsweQAAA.png?ex=688c648f&is=688b130f&hm=42ab1f0e91f145c50ff42fe6462c320bb5a09382b766f8f4c4648269dd5504ce&";
		}
		if(indice >= 300 && indice <= 600) 
		{
			item = "Armadura Completa de Vapor";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400368818387161099/OIP.png?ex=688c6297&is=688b1117&hm=04e066bbf69ffe124057c968fe962d2f1d1c3c8894feb0caafd81358b6c314e7&";
		}
		if(indice >= 600 && indice <= 900) 
		{
			item = "Armadura Completa do Artesão";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400371720396738630/aMHpA8AAAAAAA.png?ex=688c654b&is=688b13cb&hm=58227107cb9e5f205dcfc34b1b9fe78ce9149337bb58f5b16201df1c42608401&";
		}
		if(indice >= 900 && indice <= 990) 
		{
			item = "Armadura de Chakra";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400372106809835621/OIP.png?ex=688c65a7&is=688b1427&hm=c045707ae489c4c00d59b62e32aa08dd70089e0bb06fb78eb501dd1f3e34b6aa&";
		}
		if(indice >= 990 && indice <= 1000) 
		{
			item = "Armadura Otsutsuki";
			this.gif = "https://cdn.discordapp.com/attachments/1399254026402398349/1400372446556590201/OIP.png?ex=688c65f8&is=688b1478&hm=7c2408eafb720a41423d62fee58fb2193e7cdb61d32b21285edb8bd466de0178&";
		}

		return item;
	}
	public String getGif() 
	{
		return this.gif;
	}
}
