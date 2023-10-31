package com.actividades.empresa.servicio;

import com.actividades.empresa.dto.ResponseDto;
import com.actividades.empresa.dto.UsuarioRegistrarDto;
import com.actividades.empresa.modelo.Usuarios;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {
    ResponseDto registrarUsuario(UsuarioRegistrarDto usuarioRegistrarDto);
    ResponseDto validarUsuario(UsuarioRegistrarDto usuarioRegistrarDto);
    ResponseDto listarUsuario();
    ResponseDto buscarUsuario(Long id);
}
