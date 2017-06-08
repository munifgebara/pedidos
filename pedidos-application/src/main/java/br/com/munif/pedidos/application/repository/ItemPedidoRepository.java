package br.com.munif.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.munif.pedidos.domain.model.ItemPedido;

public interface ItemPedidoRepository extends GumgaCrudRepository<ItemPedido, Long> {}