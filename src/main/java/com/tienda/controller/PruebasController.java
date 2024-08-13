package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        var categorias = categoriaService.getCategorias(false);
        
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        
        model.addAttribute("totalProductos", productos.size());
        //crear URL local host
        return "/pruebas/listado";
        //finalizando el controlador para la lista
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        //para hacer la siguiente union(categoria y producto), tengo que en categoria agregar el @OneToMany @JoinColumn... List<Producto>... y en producto el private long...@ManyToOne, @JoinColumm... y Categoria categoria;
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        
        model.addAttribute("totalProductos", productos.size());
        //crear URL local host
        return "/pruebas/listado";
        //finalizando el controlador para la lista
    }
    
    //Listado 2: lista que va tener los productos con un postmapping de la solicitud del usuario de precio inf-precio sup 
    //getmapping obtiene el listado --> postmapping para la info del usuario del filtro por medio del query
    
    @GetMapping("/{listado2}")
    //model model solo porque se va mostrar la lista de los productos
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        //crear URL local host
        return "/pruebas/listado2";
        //finalizando el controlador para la lista
    }
    
    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model){
        var productos = productoService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
        
    }
    
    @PostMapping("/query2")
    public String consultaQuery2(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model){
        var productos = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
        
    }
    
    
    @PostMapping("/query3")
    public String consultaQuery3(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model){
        var productos = productoService.metodoNativo(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }

}