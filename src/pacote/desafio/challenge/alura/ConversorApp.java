package pacote.desafio.challenge.alura;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorApp {
    private Conversor conversor;


    public void moeda(String moedaBase) throws IOException, InterruptedException {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/c2caf79f61d7b5435ee75928/latest/" + moedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        this.conversor = gson.fromJson(json, Conversor.class);
    }

    public double converter(String moedaDe, String moedaPara, double valor) {

        Map<String, Double> taxas = conversor.conversion_rates();
        double taxaDeCambio = taxas.get(moedaPara) / taxas.get(moedaDe);
        return valor * taxaDeCambio;
    }

    @Override
    public String toString() {
        return "ConversorApp [" +  "moedaBase = " + conversor.moedaBase()  +  ", taxas = " + conversor.conversion_rates() + "]";
    }
}
