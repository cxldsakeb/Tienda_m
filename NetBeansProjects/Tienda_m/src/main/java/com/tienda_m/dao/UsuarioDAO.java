
package com.tienda_m.dao;

import com.tienda_m.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername(String username);
}
