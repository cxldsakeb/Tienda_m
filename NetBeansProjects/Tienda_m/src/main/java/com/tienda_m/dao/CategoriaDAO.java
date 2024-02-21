
package com.tienda_m.dao;

import com.tienda_m.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDAO extends JpaRepository<Categoria, Long>{
    
}
