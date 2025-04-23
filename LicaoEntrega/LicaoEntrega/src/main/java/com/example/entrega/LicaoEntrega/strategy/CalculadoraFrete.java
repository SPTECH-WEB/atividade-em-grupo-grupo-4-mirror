package com.example.entrega.licaoentrega.strategy;

public class CalculadoraFrete {
    private FreteStrategy estrategia;

    public void setEstrategia(FreteStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double peso, double distancia) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia de frete não definida!");
        }
        return estrategia.calcularFrete(peso, distancia);
    }
}