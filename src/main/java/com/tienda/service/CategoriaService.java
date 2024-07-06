package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //se obtiene un listado de categorias en un List
    public List <Categoria> getCategorias(boolean activos);
    
    //Se obtiene una categoria por medio de su ID
    public Categoria getCategoria(Categoria categoria);
    
    //metodo de guardar
    public void save(Categoria categoria);
    
    //Metodo de eliminar
    public void delete(Categoria categoria);
}
