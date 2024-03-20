package com.tienda_m.dao;

import com.tienda_m.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDAO extends JpaRepository<Producto, Long> {

    // Esta consulta utiliza consultas ampliadas
    public List<Producto> findByPrecioBetweenOrderByDescripcion(
            double precioInf, double precioSup);

    // Esta consulta utiliza consultas JPQL
    @Query(value="SELECT p from Producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto>
            metodoJPQL(
                    double precioInf, double precioSup);
            
    // Esta consulta utiliza consultas SQL
    @Query(nativeQuery=true,
            value="SELECT * from producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto>
            metodoSQL(
                    double precioInf, double precioSup);
            
}
