package com.example.entrega.LicaoEntrega.Observer;

import com.example.entrega.LicaoEntrega.model.Pedido;

import java.util.*;

public class Notificador {
    private List<Observer> observers = new ArrayList<>();

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void notificar(Pedido pedido) {
        for (Observer observer : observers) {
            observer.atualizar(pedido);
        }
    }
}