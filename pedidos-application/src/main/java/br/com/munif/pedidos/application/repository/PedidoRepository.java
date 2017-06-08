package br.com.munif.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.munif.pedidos.domain.model.Pedido;

public interface PedidoRepository extends GumgaCrudRepository<Pedido, Long> {}