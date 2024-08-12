package com.tienda.domain;


import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;


//TAGS vamos a recopilar datos con DATA y vamos a tener un entidad
@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable {
    
    //esto siguiente nos permite poder modiciar el ID y poder enviar toda la info y poder tranformarla o almacenarla en BD (editar, enviar, modificarlo, eliminarlo)
    private static final long serialVersionUID = 1L;
    
    
    //Es para poder hacer el autoincremento en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
       
    //Long tipo de variable para definir que es un numero o info para poder pasar/tiene un rango de espacio mas grande 
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
//    private long idCategoria;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {
    }

    public Producto(String producto, boolean activo) {
        this.descripcion = producto;
        this.activo = activo;
    }

}
