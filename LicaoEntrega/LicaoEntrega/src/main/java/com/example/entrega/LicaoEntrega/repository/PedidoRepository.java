package com.example.entrega.LicaoEntrega.repository;

import com.example.entrega.LicaoEntrega.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}