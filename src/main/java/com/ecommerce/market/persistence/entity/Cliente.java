package com.ecommerce.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 40)
    private String nombre;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 40)
    private String numero;

    @Column(length = 80)
    private String direccion;

    @Column(name = "correo_electronico", length = 40)
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}