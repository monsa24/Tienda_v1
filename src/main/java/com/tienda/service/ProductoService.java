package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //se obtiene un listado de productos en un List
    public List <Producto> getProductos(boolean activos);
    
    //Se obtiene una producto por medio de su ID
    public Producto getProducto(Producto producto);
    
    //metodo de guardar
    public void save(Producto producto);
    
    //Metodo de eliminar
    public void delete(Producto producto);
}
