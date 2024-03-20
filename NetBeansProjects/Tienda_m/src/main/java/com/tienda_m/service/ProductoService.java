/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_m.service;

import com.tienda_m.domain.Producto;
import java.util.List;

public interface ProductoService {
    //Se define la firma del metodo para obtener los registros de producto, en forma de lista
    public List<Producto> getProductos(boolean activo);
    
    //Se recupera un registro tomando el id producto como clave de busqueda
    public Producto getProducto(Producto producto);
    
    //Si idProducto tiene un  valor, se modifica ese registro,
    //Si idProducto NO tiene valor, se inserta un nuevo registro
    public void save(Producto producto);
    
    //Se elimina el registro que tenga el valor del idProducto pasado
    public void delete(Producto producto);
    
     // Esta consulta utiliza consultas ampliadas
    public List<Producto> metodoJPA(double precioInf, double precioSup);

    // Esta consulta utiliza consultas JPQL
    public List<Producto>metodoJPQL( double precioInf, double precioSup);
            
    // Esta consulta utiliza consultas SQL
    public List<Producto>metodoSQL(double precioInf, double precioSup);
            
    public List<Producto> metodoJPA2(int existenciasInf, int existenciasSup);
}
