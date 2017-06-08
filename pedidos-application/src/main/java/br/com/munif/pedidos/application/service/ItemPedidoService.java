package br.com.munif.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.munif.pedidos.application.repository.ItemPedidoRepository;
import br.com.munif.pedidos.domain.model.ItemPedido;


@Service
@Transactional
public class ItemPedidoService extends GumgaService<ItemPedido, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(ItemPedidoService.class);
    private final ItemPedidoRepository repository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

}