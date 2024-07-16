package com.aluracurso.forohub.domain.repuesta.validacion;

import com.aluracurso.forohub.domain.repuesta.DatosCrearRespuesta;
import com.aluracurso.forohub.domain.usuario.UsuarioRepository;
import com.aluracurso.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValido implements ValidadorRespuesta {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idAutor() == null || !usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("Autor no encontrado");
        }
    }
}