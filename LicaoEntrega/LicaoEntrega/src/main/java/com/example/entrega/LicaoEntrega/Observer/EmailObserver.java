package com.example.entrega.LicaoEntrega.Observer;

import com.example.entrega.LicaoEntrega.model.Pedido;

public class EmailObserver implements Observer {
    @Override
    public void atualizar(Pedido pedido) {
        System.out.println("E-mail enviado para o cliente: " + pedido.getCliente());
    }
}