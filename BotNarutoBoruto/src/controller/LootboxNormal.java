package controller;
import java.util.Random;

public class LootboxNormal {
	public String[] getLootBoxNormal() 
	{
		String[] conteudo =
			{
				"Espada de Madeira",
				"Katana de Aço",
				"Katana de Ferro",
				"Katana de Tungstênio",
				"Katana de Nióbio",
				"Pergaminho de Jutsu"
			};
		return conteudo;
	}
	public String[] getLootBoxNormalGif() 
	{
		String[] conteudo =
			{
					"https://pa1.aminoapps.com/6500/0d0309596e6a2a30c160cffbda5f6cf5ff13bf5a_hq.gif",
					"https://i.pinimg.com/originals/ef/97/a1/ef97a10e7cec505ec880e3191d954548.gif",
					"https://i.pinimg.com/originals/d1/a0/7a/d1a07a7f10eb2fa0aaaec85c69e673f9.gif",
					"https://img.wattpad.com/63367abf044618356c18f2f5b24168180181639f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f54526938704c55334667756861413d3d2d313033343931303633362e3136363866613165333463623965626135393232353735353732322e676966",
					"https://i.pinimg.com/originals/55/19/13/5519130fa53b9387ee88d2bc83dfbc2c.gif",
					"https://pa1.aminoapps.com/6538/195440f47f5922fcccc2c98248a7909184d7c8de_hq.gif"
					
			};
		return conteudo;
	}
	public String[] getLootBoxRara() 
	{
		String[] conteudo =
			{
				"Espada de Madeira",
				"Katana de Aço",
				"Katana de Ferro",
				"Katana de Tungstênio",
				"Katana de Nióbio",
				"Pergaminho de Jutsu"
			};
		return conteudo;
	}
	public String[] getLootBoxRaraGif() 
	{
		String[] conteudo =
			{
					"https://pa1.aminoapps.com/6500/0d0309596e6a2a30c160cffbda5f6cf5ff13bf5a_hq.gif",
					"https://i.pinimg.com/originals/ef/97/a1/ef97a10e7cec505ec880e3191d954548.gif",
					"https://i.pinimg.com/originals/d1/a0/7a/d1a07a7f10eb2fa0aaaec85c69e673f9.gif",
					"https://img.wattpad.com/63367abf044618356c18f2f5b24168180181639f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f54526938704c55334667756861413d3d2d313033343931303633362e3136363866613165333463623965626135393232353735353732322e676966",
					"https://i.pinimg.com/originals/55/19/13/5519130fa53b9387ee88d2bc83dfbc2c.gif",
					"https://pa1.aminoapps.com/6538/195440f47f5922fcccc2c98248a7909184d7c8de_hq.gif"
					
			};
		return conteudo;
	}
	public String[] getLootBoxLendaria() 
	{
		String[] conteudo =
			{
				"Pergaminho da Invocação",
				"Roll de caixa Dourada",
				"Katana de Nióbio",
				"Katana de Titânio",
				"Pergaminho de Jutsu",
				"Modo",
				"Secret",
			};
		return conteudo;
	}
	public String[] getLootBoxLendariaGif() 
	{
		String[] conteudo =
			{
				"https://pm1.aminoapps.com/6314/f3ba2e97098b044a5468f29a4a4539b12ca112f5_hq.jpg",
				"https://i.pinimg.com/736x/70/8f/c7/708fc72d91d361310fd8f02915b45e50.jpg",
				"https://i.pinimg.com/originals/55/19/13/5519130fa53b9387ee88d2bc83dfbc2c.gif",
				"https://cdn.discordapp.com/attachments/1399254026402398349/1400379106532655124/OIP.png?ex=688c6c2c&is=688b1aac&hm=bb12854fb3ec7e355dbddc2ec5e02253ef88663dcc7a4c6ae0fed6f87777b9f2&",
				"https://pa1.aminoapps.com/6538/195440f47f5922fcccc2c98248a7909184d7c8de_hq.gif",
				"https://i.pinimg.com/originals/78/4f/f0/784ff0c8ff33dd0a787f90e1ebabc807.gif",
				"https://i.pinimg.com/originals/0e/0b/41/0e0b4144c51278746600048e780bb8bc.gif"
					
			};
		return conteudo;
	}
	
	public String sorteiaLootbox(String tipo) {
		Random rand = new Random();
		int indice = rand.nextInt(1000);
		String item = null;
		
		if(tipo.equals("normal")) 
		{
			if(indice <= 700) 
			{
				item = "Espada de Madeira";
			}
			if(indice >= 700 && indice <= 900) 
			{
				item = "Katana de Aço";
			}
			if(indice >= 900 && indice <= 980) 
			{
				item = "Katana de Ferro";
			}
			if(indice >= 980 && indice <= 990) 
			{
				item = "Katana de Tungstênio";
			}
			if(indice >= 990 && indice <= 998) 
			{
				item = "Katana de Nióbio";
			}
			if(indice >= 998 && indice <= 1000) 
			{
				item = "Pergaminho de Jutsu";
			}
		}
		if(tipo.equals("rara")) 
		{
			if(indice <= 550) 
			{
				item = "Espada de Madeira";
			}
			if(indice >= 550 && indice <= 800) 
			{
				item = "Katana de Aço";
			}
			if(indice >= 800 && indice <= 950) 
			{
				item = "Katana de Ferro";
			}
			if(indice >= 950 && indice <= 980) 
			{
				item = "Katana de Tungstênio";
			}
			if(indice >= 980 && indice <= 995) 
			{
				item = "Katana de Nióbio";
			}
			if(indice >= 995 && indice <= 1000) 
			{
				item = "Pergaminho de Jutsu";
			}
		}
		if(tipo.equals("lendaria")) 
		{
			if(indice <= 400) 
			{
				item = "Katana de Nióbio";
			}
			if(indice >= 400 && indice <= 700) 
			{
				item = "Katana de Titânio";
			}
			if(indice >= 700 && indice <= 900) 
			{
				item = "Pergaminho de Jutsu";
			}
			if(indice >= 900 && indice <= 950) 
			{
				item = "Modo";
			}
			if(indice >= 950 && indice <= 980) 
			{
				item = "Roll de caixa Dourada";
			}
			if(indice >= 980 && indice <= 990) 
			{
				item = "Pergaminho da Invocação";
			}
			if(indice >= 990 && indice <= 1000) 
			{
				item = "Secret";
			}
		}
		return item;
	}
}
