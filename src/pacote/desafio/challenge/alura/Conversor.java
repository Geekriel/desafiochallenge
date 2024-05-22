package pacote.desafio.challenge.alura;

import java.util.Map;

public record Conversor(String moedaBase, Map<String, Double> conversion_rates) {
}
