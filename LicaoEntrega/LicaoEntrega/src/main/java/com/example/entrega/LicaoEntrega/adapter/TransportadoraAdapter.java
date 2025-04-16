package com.example.entrega.LicaoEntrega.adapter;
import com.example.entrega.LicaoEntrega.adapter.ServicoEntrega;
import com.example.entrega.LicaoEntrega.adapter.TransportadoraExternaService;


public class TransportadoraAdapter implements ServicoEntrega {

    private final TransportadoraExternaService transportadoraExterna;

    public TransportadoraAdapter() {
        this.transportadoraExterna = new TransportadoraExternaService();
    }

    @Override
    public void processarEntrega(String cliente, String produto) {
        transportadoraExterna.enviarPacote(cliente, produto);
    }
}
