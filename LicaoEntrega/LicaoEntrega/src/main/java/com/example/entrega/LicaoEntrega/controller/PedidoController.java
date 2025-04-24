package com.example.entrega.LicaoEntrega.controller;

            import com.example.entrega.LicaoEntrega.Observer.EmailObserver;
            import com.example.entrega.LicaoEntrega.Observer.LogObserver;
            import com.example.entrega.LicaoEntrega.Observer.SmsObserver;
            import com.example.entrega.LicaoEntrega.model.Pedido;
            import com.example.entrega.LicaoEntrega.Observer.Notificador;
            import com.example.entrega.LicaoEntrega.strategy.CalculadoraFrete;
            import com.example.entrega.LicaoEntrega.strategy.FreteEconomicoStrategy;
            import com.example.entrega.LicaoEntrega.strategy.FreteExpressoStrategy;
            import com.example.entrega.LicaoEntrega.strategy.FreteTransportadoraStrategy;
            import com.example.entrega.LicaoEntrega.repository.PedidoRepository;
            import jakarta.annotation.PostConstruct;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.http.ResponseEntity;
            import org.springframework.web.bind.annotation.*;

            import java.util.List;

            @RestController
            @RequestMapping("/pedidos")
            public class PedidoController {

                @Autowired
                private PedidoRepository pedidoRepository;

                private Notificador notificador = new Notificador();

                @PostConstruct
                public void init() {
                    notificador.adicionarObserver(new EmailObserver());
                    notificador.adicionarObserver(new LogObserver());
                    notificador.adicionarObserver(new SmsObserver());
                }

                @PostMapping
                public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {

                    Pedido pedidoSalvo = pedidoRepository.save(pedido);


                    double distancia = 10.0;
                    CalculadoraFrete calculadoraFrete = new CalculadoraFrete();


                    switch (pedido.getTipoEntrega()) {
                        case "economica":
                            calculadoraFrete.setEstrategia(new FreteEconomicoStrategy());
                            break;
                        case "expressa":
                            calculadoraFrete.setEstrategia(new FreteExpressoStrategy());
                            break;
                        case "transportadora":
                            calculadoraFrete.setEstrategia(new FreteTransportadoraStrategy());
                            break;
                        default:
                            return ResponseEntity.badRequest().build();
                    }


                    double valorFrete = calculadoraFrete.calcular(pedido.getPeso(), distancia);
                    System.out.println("Valor do frete para o pedido: " + valorFrete);

                    notificador.notificar(pedido);

                    return ResponseEntity.ok(pedidoSalvo);
                }

                @GetMapping
                public List<Pedido> listarPedidos() {
                    return pedidoRepository.findAll();
                }
            }