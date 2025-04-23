package com.example.entrega.LicaoEntrega.Observer;

import com.example.entrega.LicaoEntrega.model.Pedido;

public class LogObserver implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("Log: Pedido processado: " + pedido);
    }
}