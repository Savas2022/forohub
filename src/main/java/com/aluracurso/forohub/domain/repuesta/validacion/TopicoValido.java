package com.aluracurso.forohub.domain.repuesta.validacion;

import com.aluracurso.forohub.domain.repuesta.DatosCrearRespuesta;
import com.aluracurso.forohub.domain.topico.TopicoRepository;
import com.aluracurso.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoValido implements ValidadorRespuesta {

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idTopico() == null || !topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }
}
