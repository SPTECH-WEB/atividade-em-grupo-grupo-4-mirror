package com.example.entrega.licaoentrega.strategy;

public class FreteTransportadoraStrategy implements FreteStrategy {
    @Override
    public double calcularFrete(double peso, double distancia) {
        return (peso * 0.8) + (distancia * 0.4) + 10.0; // taxa fixa adicional
    }
}