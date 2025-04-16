package com.example.entrega.LicaoEntrega.adapter;

public class TransportadoraExternaService {

    public void enviarPacote(String nomeDestinatario, String descricaoProduto) {
        System.out.println("[Transportadora Externa] Enviando pacote para " + nomeDestinatario + ": " + descricaoProduto);
    }
}
