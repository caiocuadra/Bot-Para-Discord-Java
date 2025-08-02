package model;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import controller.Saldo;
import utils.inventarioUtils;

public class Inventario {
	public int saldo;
	public long userId;
	public String inventario;
	public String transacao;
	public Map<String, Integer> itens;
	public Map<String, Integer> itensInventario = new HashMap<>();
	
	public void verificaSaldoParaCompra(int saldo, int item, int quantidade) 
	{
		Map<Integer, Integer> mapaDeItens = new HashMap<>();
		mapaDeItens.put(1, 200);
		mapaDeItens.put(2, 300);
		mapaDeItens.put(3, 40);
		mapaDeItens.put(4, 10);
		mapaDeItens.put(5, 30);
		mapaDeItens.put(6, 250);
		mapaDeItens.put(7, 230);
		mapaDeItens.put(8, 300);
		
		if(mapaDeItens.containsKey(item)) 
		{
			int valorItem = mapaDeItens.get(item);
			if(saldo >= valorItem * quantidade) 
			{
				this.transacao = "Compra realizada com sucesso.";
				Saldo sd = new Saldo(this.userId);
				sd.remover(valorItem * quantidade);
				
				if(item == 1) {
					itensInventario.put("Kunai Explosiva Avançada", quantidade);
					this.adicionarItem("Kunai Explosiva Avançada", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 2) {
					itensInventario.put("Shuriken Bumerangue", quantidade);
					this.adicionarItem("Shuriken Bumerangue", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 3) {
					itensInventario.put("Senbon Envenenado", quantidade);
					this.adicionarItem("Senbon Envenenado", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 4) {
					itensInventario.put("Senbon", quantidade);
					this.adicionarItem("Senbon", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 5) {
					itensInventario.put("Fio de Aço", quantidade);
					this.adicionarItem("Fio de Aço", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 6) {
					itensInventario.put("Pílula de Soldado", quantidade);
					this.adicionarItem("Pílula de Soldado", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 7) {
					itensInventario.put("Pomada de Cura Rápida", quantidade);
					this.adicionarItem("Pomada de Cura Rápida", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				if(item == 8) {
					itensInventario.put("Essência de Flor de Lótus Branca", quantidade);
					this.adicionarItem("Essência de Flor de Lótus Branca", quantidade);
					inventarioUtils.salvarInventario(this);
				}
				
			}else {
				this.transacao = "Saldo insuficiente.";
			}
			
			
		}else {
			this.transacao = "O item digitado não existe.";
		}
		
		
	}
	
	public Inventario(long userId) 
	{
		this.userId = userId;
		this.itens = new HashMap<>();
	}
	public long getUserId() 
	{
		return userId;
	}
	public String getTransacao() {
		return this.transacao;
	}
	public Map<String, Integer> getItens(){
		return itens;
	}
	public void adicionarItem(String item, int quantidade) 
	{
		itens.put(item, itens.getOrDefault(item, 0) + quantidade);
	}
	public void removerItem(String item, int quantidade) 
	{
		if(itens.containsKey(item)) {
			System.out.println("Item encontrado.");
			int restante = itens.get(item) - quantidade;
			if(restante <= 0) {
				itens.remove(item);
			} else {
				System.out.println("Item não encontrado");
				itens.put(item, restante);
			}
		}
	}
	
}
