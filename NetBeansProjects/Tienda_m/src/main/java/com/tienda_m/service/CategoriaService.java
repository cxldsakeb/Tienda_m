/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_m.service;

import com.tienda_m.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se define la firma del metodo para obtener los registros de categoria, en forma de lista
    public List<Categoria> getCategorias(boolean activo);
    
    //Se recupera un registro tomando el id categoria como clave de busqueda
    public Categoria getCategoria(Categoria categoria);
    
    //Si idCategoria tiene un  valor, se modifica ese registro,
    //Si idCategoria NO tiene valor, se inserta un nuevo registro
    public void save(Categoria categoria);
    
    //Se elimina el registro que tenga el valor del idCategoria pasado
    public void delete(Categoria categoria);
}
