package br.com.munif.pedidos.application.repository;

import io.gumga.domain.repository.GumgaCrudRepository;
import br.com.munif.pedidos.domain.model.Categoria;

public interface CategoriaRepository extends GumgaCrudRepository<Categoria, Long> {}