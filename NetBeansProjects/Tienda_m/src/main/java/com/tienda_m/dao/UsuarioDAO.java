
package com.tienda_m.dao;

import com.tienda_m.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    public Usuario findByUsername(String username);
    
    public Usuario findByUsernameAndPassword(String username, String Password);

    public Usuario findByUsernameOrCorreo(String username, String correo);

    public boolean existsByUsernameOrCorreo(String username, String correo);
}
