
package com.proyectoWeb.controller;

import com.proyectoWeb.domain.Producto;
import com.proyectoWeb.service.CategoriaService;
import com.proyectoWeb.service.ProductoService;
import com.proyectoWeb.service.FireBaseStorageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        return "/productos/listado";
    }
    
    @GetMapping("/Enlatados")
    public String enlatados(Model model){
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        return "/productos/Enlatados";
    }
    
    @GetMapping("/Leguminosas")
    public String leguminosas(Model model){
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        return "/productos/Leguminosas";
    }
    
    @GetMapping("/Panaderia")
    public String panaderia(Model model){
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        return "/productos/Panaderia";
    }
    
    @Autowired
    private FireBaseStorageService firebaseStorageService;
    
    @GetMapping("/donacion")
    public String donacion() {

        return "/productos/donacion";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam("query") String query, Model model) {
        // Normalizamos la búsqueda a minúsculas para evitar problemas de mayúsculas/minúsculas
        String normalizedQuery = query.toLowerCase();

        // Lógica para redirigir a la categoría específica si el nombre coincide con alguna categoría
        if (normalizedQuery.equals("enlatados")) {
            return "redirect:/productos/Enlatados";
        } else if (normalizedQuery.equals("leguminosas")) {
            return "redirect:/productos/Leguminosas";
        } else if (normalizedQuery.equals("panaderia")) {
            return "redirect:/productos/Panaderia";
        } else if (normalizedQuery.equals("donacion")) {
            return "redirect:/productos/donacion";
        }

        // Buscar productos que coincidan con la descripción
        List<Producto> productos = productoService.buscarPorDescripcion(normalizedQuery);

        if (!productos.isEmpty()) {
            // Si hay productos, obtenemos la primera categoría de la lista
            String categoria = productos.get(0).getCategoria().getDescripcion();
            return "redirect:/productos/" + categoria;
        }

        // Si no se encuentra nada, redirigir a un listado vacío o mostrar un mensaje
        return "redirect:/productos/listado";
    }
}


    