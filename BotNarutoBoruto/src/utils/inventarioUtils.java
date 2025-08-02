package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Inventario;

public class inventarioUtils {
	private static final String PASTA = "inventarios/";
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static void salvarInventario(Inventario novoInventario) {
	    try {
	        Files.createDirectories(Paths.get(PASTA));
	        File arquivo = new File(PASTA + novoInventario.getUserId() + ".json");

	        if (arquivo.exists()) {
	            // 1️⃣ Carrega o inventário antigo
	            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
	            Inventario antigoInventario = gson.fromJson(reader, Inventario.class);
	            reader.close();

	            // 2️⃣ Mescla os itens do novo com o antigo
	            for (Map.Entry<String, Integer> entry : novoInventario.getItens().entrySet()) {
	                String item = entry.getKey();
	                int qtd = entry.getValue();
	                antigoInventario.adicionarItem(item, qtd); // soma ao que já existia
	            }

	            // 3️⃣ Atualiza o objeto a ser salvo
	            novoInventario = antigoInventario;
	        }

	        // 4️⃣ Salva o inventário final (novo ou mesclado)
	        FileWriter writer = new FileWriter(arquivo);
	        gson.toJson(novoInventario, writer);
	        writer.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void salvarInventarioSobrescrevendo(Inventario inventario) {
	    try {
	        Files.createDirectories(Paths.get(PASTA));
	        FileWriter writer = new FileWriter(PASTA + inventario.getUserId() + ".json");
	        gson.toJson(inventario, writer);
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static Inventario carregarInventario(long userId) {
		try {
			File file = new File(PASTA + userId + ".json");
			if(!file.exists()) return new Inventario(userId);
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Inventario inventario = gson.fromJson(reader, Inventario.class);
			reader.close();
			return inventario;
		} catch (IOException e) {
			e.printStackTrace();
			return new Inventario(userId);
		}
	}
	
	public static void deletarInventario(long userId) {
		File file = new File(PASTA + userId + ".json");
		if(file.exists()) file.delete();
	}
}
