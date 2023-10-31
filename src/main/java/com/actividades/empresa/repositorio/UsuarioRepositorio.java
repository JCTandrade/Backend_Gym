package com.actividades.empresa.repositorio;

import com.actividades.empresa.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios,Long> {

    Usuarios findByUsuarioCorreo(String correo);
    Usuarios findByUsuarioCorreoAndUsuarioPassword(String correo, String password);
}
