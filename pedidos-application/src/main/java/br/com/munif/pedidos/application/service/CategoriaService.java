package br.com.munif.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.munif.pedidos.application.repository.CategoriaRepository;
import br.com.munif.pedidos.domain.model.Categoria;


@Service
@Transactional
public class CategoriaService extends GumgaService<Categoria, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(CategoriaService.class);
    private final CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        super(repository);
        this.repository = repository;
    }

}