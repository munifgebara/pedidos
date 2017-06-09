package br.com.munif.pedidos.application.service;

import io.gumga.application.GumgaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

import br.com.munif.pedidos.application.repository.PedidoRepository;
import br.com.munif.pedidos.application.repository.ProdutoRepository;
import br.com.munif.pedidos.domain.model.Pedido;

import br.com.munif.pedidos.domain.model.ItemPedido;
import br.com.munif.pedidos.domain.model.Produto;

@Service
@Transactional
public class PedidoService extends GumgaService<Pedido, Long> {

    private final static Logger LOG = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository repository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    public PedidoService(PedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public Pedido loadPedidoFat(Long id) {
    Pedido obj = view(id);
        Hibernate.initialize(obj.getItens());
    return obj;
    }

    @Override
    public void beforeSave(Pedido entity) {
        for (ItemPedido item:entity.getItens()){
            item.setPedido(entity);
            Produto p=produtoRepository.findOne(item.getProduto().getId());
            p.setQuantidade(item.getQuantidade()+p.getQuantidade());
        }
    }

    @Override
    public void beforeUpdate(Pedido entity) {
        for (ItemPedido item:entity.getItens()){
            item.setPedido(entity);
        }
    }
    
    
    
    
}