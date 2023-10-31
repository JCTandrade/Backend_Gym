package com.actividades.empresa.servicio.Impl;

import com.actividades.empresa.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks UsuarioService usuarioService;

    @Mock
    UsuarioRepositorio usuarioRepositorio;

    @Test
    void testValidarUsuarioId(){
        Mockito.when(usuarioService.usuarioRepositorio.findById(Mockito.any())).thenReturn(Optional.empty());

        var servicio = this.usuarioService.buscarUsuario(3L);

        Assertions.assertNotNull(servicio);
    }

}