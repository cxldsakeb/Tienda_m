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
}
