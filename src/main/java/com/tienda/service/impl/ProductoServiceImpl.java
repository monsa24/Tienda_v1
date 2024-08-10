package com.tienda.service.impl;

import com.tienda.dao.ProductoDao; 
import com.tienda.domain.Producto; 
import com.tienda.service.ProductoService; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service  //pertenece a la capa de SERVICIOS
//implement porque implementamos una interface ProductoService
public class ProductoServiceImpl implements ProductoService{
    
    //vamos a utilizar el ProductoDao porque tiene toda la info del primary key y BD
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getIdProducto()).orElse(null);
        
    }
    
    @Override
    @Transactional
    //guarda y actualiza: SAVE
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    @Override
    @Transactional  
    public void delete(Producto producto){
        productoDao.delete(producto);
    }
    
    

}
