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

@GumgaMultitenancy
@Audited
@Entity(name = "ItemPedido")
@Table(name = "ItemPedido", indexes = {
    @Index(name = "ItemPedido_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_ItemPedido")
public class ItemPedido extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @ManyToOne
	private Produto produto;
    @Column(name = "quantidade")
	private Integer quantidade;
    @ManyToOne
	private Pedido pedido;

    public ItemPedido() {}

	public Produto getProduto() {
		return this.produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
