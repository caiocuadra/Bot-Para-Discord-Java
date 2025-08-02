package controller;
import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Saldo {
    private static final String PASTA = "saldos/";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private int saldo;
    private long userId;

    public Saldo(long userId) {
        this.userId = userId;
        this.saldo = carregarSaldo();
    }

    private String getCaminhoArquivo() {
        return PASTA + userId + ".json";
    }

    // Salvar o saldo atual no arquivo
    public void salvarSaldo() {
        try {
            Files.createDirectories(Paths.get(PASTA));
            Map<String, Integer> saldoJson = new HashMap<>();
            saldoJson.put("saldo", this.saldo);
            FileWriter writer = new FileWriter(getCaminhoArquivo());
            gson.toJson(saldoJson, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carregar o saldo do arquivo
    private int carregarSaldo() {
        try {
            File file = new File(getCaminhoArquivo());
            if (!file.exists()) return 0;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            Map<?, ?> saldoLido = gson.fromJson(reader, Map.class);
            reader.close();

            Double saldoDouble = (Double) saldoLido.get("saldo"); // Gson retorna número como Double
            return saldoDouble.intValue();

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Métodos públicos para acessar ou alterar o saldo
    public int getSaldo() {
        return this.saldo;
    }

    public void adicionar(int valor) {
        this.saldo += valor;
        salvarSaldo();
    }

    public boolean remover(int valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            salvarSaldo();
            return true;
        }
        return false;
    }
}

