package br.com.munif.pedidos.domain.model;

import io.gumga.domain.GumgaModel; //TODO RETIRAR OS IMPORTS DESNECESS?RIOS
import io.gumga.domain.GumgaMultitenancy;
import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;
import io.gumga.domain.domains.*;
import org.hibernate.annotations.Columns;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@GumgaMultitenancy
@Audited
@Entity(name = "Pedido")
@Table(name = "Pedido", indexes = {
    @Index(name = "Pedido_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Pedido")
public class Pedido extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "cliente")
    private String cliente;

    @JsonIgnoreProperties({"pedido"})
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ItemPedido> itens;

    public Pedido() {
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

}
