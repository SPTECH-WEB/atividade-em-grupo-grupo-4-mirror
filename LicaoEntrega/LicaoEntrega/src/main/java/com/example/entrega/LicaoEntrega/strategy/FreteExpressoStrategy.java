package com.example.entrega.LicaoEntrega.strategy;

public class FreteExpressoStrategy implements FreteStrategy {
    @Override
    public double calcularFrete(double peso, double distancia) {
        return (peso * 1.0) + (distancia * 0.5);
    }
}