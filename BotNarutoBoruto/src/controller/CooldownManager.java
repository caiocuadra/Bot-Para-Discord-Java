package controller;
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

public class CooldownManager {
    private static final String PASTA = "cooldowns/";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarCooldown(String tipo, long userId, long timestamp) {
        try {
            Files.createDirectories(Paths.get(PASTA));
            File file = new File(PASTA + tipo + "/" + userId + ".json");
            Files.createDirectories(file.getParentFile().toPath());
            FileWriter writer = new FileWriter(file);
            gson.toJson(Map.of("timestamp", timestamp), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Long carregarCooldown(String tipo, long userId) {
        File file = new File(PASTA + tipo + "/" + userId + ".json");
        if (!file.exists()) return 0L;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Map<?, ?> data = gson.fromJson(reader, Map.class);
            reader.close();
            return ((Double) data.get("timestamp")).longValue();
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void apagarCooldown(String tipo, long userId) {
        File file = new File(PASTA + tipo + "/" + userId + ".json");
        if (file.exists()) file.delete();
    }
}