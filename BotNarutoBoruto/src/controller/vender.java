package controller;

import model.Inventario;
import utils.inventarioUtils;

public class vender {
	public int retornaValores(String item) {
		switch (item) {
		case "Ferro": {
			
			return 20;
		}
		case "Nióbio": {
			return 30;
		}
		case "Tungstênio": {
			return 50;
		}
		case "Titânio": {
			return 60;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + item);
		}
	}
	public void venderItem(String item, long userId, int quantidade) {
		int valor = retornaValores(item);
		Inventario inv = inventarioUtils.carregarInventario(userId);
		System.out.println(inv.getItens());
		inv.removerItem(item, quantidade);
		System.out.println(inv.getItens());
		inventarioUtils.salvarInventarioSobrescrevendo(inv);
		Saldo sd = new Saldo(userId);
		sd.adicionar(valor*quantidade);
		sd.salvarSaldo();
	}
}
