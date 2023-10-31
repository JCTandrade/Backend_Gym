package com.actividades.empresa.dto;

import lombok.Data;
import org.springframework.core.SpringVersion;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioRegistrarDto {

    @NotNull(message = "El correo electronico no puede ser vacio")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    private String correo;

    @NotNull(message = "La contraseña no puese ser vacia")
    private String password;
}
