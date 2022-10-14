package com.ecommerce.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente", length = 20)
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago", length = 1)
    private String medioPago;

    @Column(length = 300)
    private String comentario;

    private String estado;

    //RELACIONES ENTRE CLASES
    //RELACIÓN COMPRA --> CLIENTE
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //RELACIÓN COMPRA --> COMPRAS_PRODUCTOS
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "compra")
    private List<ComprasProducto> productos;
}