package com.aluracurso.forohub.domain.topico.validacion;

import com.aluracurso.forohub.domain.topico.DatosCrearTopico;
import com.aluracurso.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoExistente implements ValidadorTopico{

    @Autowired
    TopicoRepository topicoRepository;


    @Override
    public void validar(DatosCrearTopico datos) {
        var tituloExistente = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if(tituloExistente != null && tituloExistente) {
            throw new ValidationException("Ya existe un topico con ese titulo.");
        }
    }
}
