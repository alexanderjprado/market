// Mapping tables as classes

package com.ecommerce.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {
    //Declaring variables

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    //Getter & Setter Methods

    public Integer getIdCategory() {
        return idCategoria;
    }

    public void setId(Integer id) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}