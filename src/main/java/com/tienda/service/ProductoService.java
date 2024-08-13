package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface ProductoService {
    
    //se obtiene un listado de productos en un List
    public List <Producto> getProductos(boolean activos);
    
    //Se obtiene una producto por medio de su ID
    public Producto getProducto(Producto producto);
    
    //metodo de guardar
    public void save(Producto producto);
    
    //Metodo de eliminar
    public void delete(Producto producto);
    
    //copiando el Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    //irse a productoServiceImpl a copiar y pegar esta linea de codigo de arribita y en ProductoDao
    // ProductoDao.java (interface) --> ProductoService.java(interface)--> ProductoServiceImpl.java (java class)
    
    
    //esto le hace el select a la BD
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
