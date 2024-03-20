/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.controller;

import com.tienda_m.domain.Categoria;
import com.tienda_m.service.CategoriaService;
import com.tienda_m.service.ProductoService;
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
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        //Para poder hacer los options del select...
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listadoIds(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        var productos = categoria.getProductos();
        model.addAttribute("productos", productos);
  
        //Para poder hacer los options del select...
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        //Para poder hacer los options del select...
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado2";
    }
    @PostMapping("/query1")
    public String consultaquery(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model){
        
        var lista = productoService.metodoJPA(precioInf,precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
     @PostMapping("/query2")
    public String consultaquery2(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model){
        
        var lista = productoService.metodoJPQL(precioInf,precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
     @PostMapping("/query3")
    public String consultaquery3(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model){
        
        var lista = productoService.metodoSQL(precioInf,precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query4")
    public String consultaquery4(
            @RequestParam(value="existenciasInf") int existenciasInf,
            @RequestParam(value="existenciasSup") int existenciasSup,
            Model model){
        
        var lista = productoService.metodoJPA2(existenciasInf,existenciasSup);
        model.addAttribute("productos", lista);
        model.addAttribute("existenciasInf",existenciasInf);
        model.addAttribute("existenciasSup",existenciasSup);
        return "/pruebas/listado2";
    }

}
