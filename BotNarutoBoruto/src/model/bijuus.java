package model;
import java.util.Random;

public class bijuus {
	public String[] getBijuus() 
	{
		String[] conteudo = 
			{
					"1 Cauda",
					"2 Caudas",
					"3 Caudas",
					"4 Caudas",
					"5 Caudas",
					"6 Caudas",
					"7 Caudas",
					"8 Caudas",
					"9 Caudas"
			};
		return conteudo;
	}
	public String[] getGifBijuus() 
	{
		String[] conteudo = {
		"https://static.wikia.nocookie.net/naruto/images/e/ea/Ichibi.png/revision/latest?cb=20131015175254&path-prefix=pt-br",
		"https://static.wikia.nocookie.net/fiction-battlefield/images/a/a7/Matatabi.png/revision/latest?cb=20190416195811&path-prefix=pt-br",
		"https://static.wikia.nocookie.net/naruto/images/a/a7/Isobu.PNG/revision/latest?cb=20200212142837&path-prefix=pt-br",
		"https://divertidoanime.com/wp-content/uploads/2022/02/son-goku.png",
		"https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgd3MpzOGI55fr2j5bpTMRuGo5cBuWWnTeEZbKk-tsnp6Jlz9TAU7UkrT0XyLnRTmenMKPZ4A15DeK5J2vZATeBk1gsN0GMcxaPhfq7fP5v9TyDnQbt7JKPOMuwRS4Eaj2VPxEj5DNkI6Jd/s1600/Kokuo.png",
		 "https://i.ytimg.com/vi/l-UXokhjyes/maxresdefault.jpg",
		"https://i.redd.it/ina4xo8qyqh11.jpg",
		"https://static.wikia.nocookie.net/naruto/images/d/d7/Gyuki.png/revision/latest?cb=20130513214423&path-prefix=pt-br",
		"https://criticalhits.com.br/wp-content/uploads/2023/04/kurama_capa_widelg.jpg"
		};
		return conteudo;
	}
	
	public String gif;
	
	public String sorteiaBijuu() {
		Random rand = new Random();
		int indice = rand.nextInt(101);
		String bijuu = null;
		String gif = null;
		if(indice <= 20) 
		{
			bijuu = "Bijuu de 1 Cauda";
			this.gif = "https://static.wikia.nocookie.net/naruto/images/e/ea/Ichibi.png/revision/latest?cb=20131015175254&path-prefix=pt-br";
		}
		if(indice >= 20 && indice <= 40) 
		{
			bijuu = "Bijuu de 2 Caudas";
			this.gif = "https://static.wikia.nocookie.net/fiction-battlefield/images/a/a7/Matatabi.png/revision/latest?cb=20190416195811&path-prefix=pt-br";
		}
		if(indice >= 40 && indice <= 60) 
		{
			bijuu = "Bijuu de 3 Caudas";
			this.gif = "https://static.wikia.nocookie.net/naruto/images/a/a7/Isobu.PNG/revision/latest?cb=20200212142837&path-prefix=pt-br";
		}
		if(indice >= 60 && indice <= 70) 
		{
			bijuu = "Bijuu de 4 Caudas";
			this.gif = "https://divertidoanime.com/wp-content/uploads/2022/02/son-goku.png";
		}
		if(indice >= 70 && indice <= 80) 
		{
			bijuu = "Bijuu de 5 Caudas";
			this.gif = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgd3MpzOGI55fr2j5bpTMRuGo5cBuWWnTeEZbKk-tsnp6Jlz9TAU7UkrT0XyLnRTmenMKPZ4A15DeK5J2vZATeBk1gsN0GMcxaPhfq7fP5v9TyDnQbt7JKPOMuwRS4Eaj2VPxEj5DNkI6Jd/s1600/Kokuo.png";
		}
		if(indice >= 80 && indice <= 90) 
		{
			bijuu = "Bijuu de 6 Caudas";
			this.gif = "https://i.ytimg.com/vi/l-UXokhjyes/maxresdefault.jpg";
		}
		if(indice >= 90 && indice <= 95) 
		{
			bijuu = "Bijuu de 7 Caudas";
			this.gif = "https://i.redd.it/ina4xo8qyqh11.jpg";
		}
		if(indice >= 95 && indice <= 99) 
		{
			bijuu = "Bijuu de 8 Caudas";
			this.gif = "https://i.redd.it/ina4xo8qyqh11.jpg";
		}
		if(indice >= 99 && indice <= 100) 
		{
			bijuu = "Bijuu de 9 Caudas";
			this.gif = "https://criticalhits.com.br/wp-content/uploads/2023/04/kurama_capa_widelg.jpg";
		}
		
		return bijuu;
	}
	public String getGif() 
	{
		return this.gif;
	}
}
