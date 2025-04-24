package com.example.entrega.LicaoEntrega.strategy;

public class FreteEconomicoStrategy implements FreteStrategy {
    @Override
    public double calcularFrete(double peso, double distancia) {
        return (peso * 0.5) + (distancia * 0.2);
    }
}