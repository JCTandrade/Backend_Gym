package com.actividades.empresa.controlador;

import com.actividades.empresa.dto.ResponseDto;
import com.actividades.empresa.dto.UsuarioRegistrarDto;
import com.actividades.empresa.servicio.IUsuarioService;
import com.actividades.empresa.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = Constantes.PATH +"/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioControlador {

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping(path = "listar-usuario")
    public ResponseEntity<ResponseDto>listarUsuario(){
        var servicio = this.usuarioService.listarUsuario();
        return new ResponseEntity<>(servicio,servicio.getStatus());
    }
    @GetMapping(path = "buscar-usuario/{id}")
    public ResponseEntity<ResponseDto>buscarUsuario(@PathVariable Long id){
        var servicio = this.usuarioService.buscarUsuario(id);
        return new ResponseEntity<>(servicio, servicio.getStatus());
    }

    @PostMapping(path = "registrar-usuario")
    public ResponseEntity<ResponseDto>registrarUsuario(@Valid @RequestBody UsuarioRegistrarDto usuarioRegistrarDto){
        var servicio = this.usuarioService.registrarUsuario(usuarioRegistrarDto);
        return  new ResponseEntity<>(servicio,servicio.getStatus());
    }

    @PostMapping(path = "validar-usuario")
    public ResponseEntity<ResponseDto>validarUsario(@Valid @RequestBody UsuarioRegistrarDto usuarioRegistrarDto){
        var servicio = this.usuarioService.validarUsuario(usuarioRegistrarDto);
        return  new ResponseEntity<>(servicio,servicio.getStatus());
    }

}
