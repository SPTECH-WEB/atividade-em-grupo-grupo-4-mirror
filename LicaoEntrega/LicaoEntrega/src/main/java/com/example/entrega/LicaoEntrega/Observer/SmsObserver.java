package com.example.entrega.LicaoEntrega.Observer;

import com.example.entrega.LicaoEntrega.model.Pedido;

public class SmsObserver implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("SMS enviado para o cliente: " + pedido.getCliente());
    }
}