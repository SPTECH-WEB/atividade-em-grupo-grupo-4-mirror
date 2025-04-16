package com.example.entrega.LicaoEntrega.controller;

import com.example.entrega.LicaoEntrega.model.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarEPersistirPedido(pedido);
    }


    @GetMapping
    public List<Pedido> listarTodosPedidos() {
        return pedidoService.listarPedidos();
    }
}