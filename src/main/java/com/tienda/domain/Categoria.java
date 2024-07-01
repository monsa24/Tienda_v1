package com.tienda.domain;


import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;


//TAGS vamos a recopilar datos con DATA y vamos a tener un entidad
@Data
@Entity
@Table(name="categoria")

public class Categoria implements Serializable {
    
    //esto siguiente nos permite poder modiciar el ID y poder enviar toda la info y poder tranformarla o almacenarla en BD (editar, enviar, modificarlo, eliminarlo)
    private static final long serialVersionUID = 1L;
    
    
    //Es para poder hacer el autoincremento en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
       
    //Long tipo de variable para definir que es un numero o info para poder pasar/tiene un rango de espacio mas grande 
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }

}
