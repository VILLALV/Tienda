package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Producto> productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProducto", productos.size());

        List<Categoria> categorias = categoriaService.getCategorias(true);
            model.addAttribute("categorias", categorias);
        return "/producto/listado";
    }

    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            
            
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto categoria) {
        productoService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto categoria, Model model) {
        categoria = productoService.getProducto(categoria);
        model.addAttribute("categoria", categoria);
        
        List<Categoria> categorias = categoriaService.getCategorias(true);
            model.addAttribute("categorias", categorias);
            
        return "/categoria/modifica";
    }
}
