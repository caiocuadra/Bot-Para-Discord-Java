import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class inventarioUtils {
	private static final String PASTA = "inventarios/";
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static void salvarInventario(Inventario inventario) {
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
