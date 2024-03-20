/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.service.impl;

import com.tienda_m.dao.ProductoDAO;
import com.tienda_m.domain.Producto;
import com.tienda_m.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose1
 */
@Service
public class ProductoServiceImpl 
        implements ProductoService{
    
    @Autowired
    private ProductoDAO productoDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista=productoDAO.findAll();
        if (activo){
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDAO.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDAO.delete(producto);
    }
    
    // Esta consulta utiliza consultas ampliadas
    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPA(double precioInf, double precioSup){
       return productoDAO.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    // Esta consulta utiliza consultas JPQL
    @Override
    @Transactional(readOnly = true)
    public List<Producto>metodoJPQL( double precioInf, double precioSup){
        return productoDAO.metodoJPQL(precioInf, precioSup);
    }
            
    // Esta consulta utiliza consultas SQL}
    @Override
    @Transactional(readOnly = true)
    public List<Producto>metodoSQL(double precioInf, double precioSup){
        return productoDAO.metodoSQL(precioInf, precioSup);
    }
    
}
