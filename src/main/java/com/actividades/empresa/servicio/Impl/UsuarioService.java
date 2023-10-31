package com.actividades.empresa.servicio.Impl;

import com.actividades.empresa.dto.ResponseDto;
import com.actividades.empresa.dto.UsuarioRegistrarDto;
import com.actividades.empresa.modelo.Usuarios;
import com.actividades.empresa.repositorio.UsuarioRepositorio;
import com.actividades.empresa.servicio.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Override
    public ResponseDto registrarUsuario(UsuarioRegistrarDto usuarioRegistrarDto) {
        ResponseDto responseDto = new ResponseDto();
        Usuarios validaCorreo = this.usuarioRepositorio.findByUsuarioCorreo(usuarioRegistrarDto.getCorreo());
        if (Objects.isNull(validaCorreo)){
            validaCorreo = new Usuarios();
            validaCorreo.setUsuarioCorreo(usuarioRegistrarDto.getCorreo());
            validaCorreo.setUsuarioPassword(usuarioRegistrarDto.getPassword());
            this.usuarioRepositorio.save(validaCorreo);
            responseDto.setError(false);
            responseDto.setStatus(HttpStatus.OK);
            responseDto.setMensaje(validaCorreo);
            return responseDto;
        }
        responseDto.setError(true);
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMensaje("La información suministrada ya existe");
        return responseDto;
    }

    @Override
    public ResponseDto validarUsuario(UsuarioRegistrarDto usuarioRegistrarDto) {
        ResponseDto responseDto = new ResponseDto();
        Usuarios consultaCredenciales = this.usuarioRepositorio.findByUsuarioCorreoAndUsuarioPassword(usuarioRegistrarDto.getCorreo(), usuarioRegistrarDto.getPassword());
        if (Objects.nonNull(consultaCredenciales)){
            responseDto.setMensaje(consultaCredenciales);
            responseDto.setError(true);
            responseDto.setStatus(HttpStatus.OK);
            return responseDto;
        }
        responseDto.setMensaje("No existe usuario con la informacion suministrada");
        responseDto.setError(false);
        responseDto.setStatus(HttpStatus.OK);
        return responseDto;
    }

    @Override
    public ResponseDto listarUsuario() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setError(false);
        responseDto.setStatus(HttpStatus.OK);
        List<Usuarios> listaUsuarios = this.usuarioRepositorio.findAll();
        if(listaUsuarios.isEmpty()){
            responseDto.setMensaje("No existe usuario registrados");
        }else {
            responseDto.setMensaje(listaUsuarios);
        }
        return responseDto;
    }

    @Override
    public ResponseDto buscarUsuario(Long id) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setError(false);
        responseDto.setStatus(HttpStatus.OK);

        Optional<Usuarios> usuario = this.usuarioRepositorio.findById(id);
        if(usuario.isPresent()){
            responseDto.setMensaje(usuario.get());
        }else {
            responseDto.setMensaje("No existe un usuario con el ID: " + id);
        }
        return responseDto;
    }
}
