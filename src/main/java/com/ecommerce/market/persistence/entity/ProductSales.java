package com.ecommerce.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ProductSales {

    @EmbeddedId
    private ProductSalesPK id;
    private Integer cantidad;
    private Double total;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;

    // Getter & Setter methods

    public ProductSalesPK getId() {
        return id;
    }

    public void setId(ProductSalesPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
