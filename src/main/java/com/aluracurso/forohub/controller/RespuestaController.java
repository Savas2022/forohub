package com.aluracurso.forohub.controller;

import com.aluracurso.forohub.domain.repuesta.DatosCrearRespuesta;
import com.aluracurso.forohub.domain.repuesta.DatosEditarRespuesta;
import com.aluracurso.forohub.domain.repuesta.RespuestaService;
import com.aluracurso.forohub.domain.topico.EstadoTopicoRespuesta;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearRespuesta(@RequestBody @Valid DatosCrearRespuesta datos) {
        var response = service.crearRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid DatosEditarRespuesta datos) {
        var response = service.editarRespuesta(datos);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity cambiarEstadoRespuesta(@PathVariable Long id) {
        EstadoTopicoRespuesta response = service.marcarDesmarcarComoSolucion(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        service.eliminarRespuesta(id);
        return ResponseEntity.ok().build();
    }
}
