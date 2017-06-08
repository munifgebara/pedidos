package br.com.munif.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.munif.pedidos.domain.model.Produto;

public interface ProdutoRepository extends GumgaCrudRepository<Produto, Long> {}