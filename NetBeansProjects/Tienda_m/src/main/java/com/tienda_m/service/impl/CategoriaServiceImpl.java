/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_m.service.impl;

import com.tienda_m.dao.CategoriaDAO;
import com.tienda_m.domain.Categoria;
import com.tienda_m.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose1
 */
@Service
public class CategoriaServiceImpl 
        implements CategoriaService{
    
    @Autowired
    private CategoriaDAO categoriaDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var lista=categoriaDAO.findAll();
        if (activo){
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }
    
}
