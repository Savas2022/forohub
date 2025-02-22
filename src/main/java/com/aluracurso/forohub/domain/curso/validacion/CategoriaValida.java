package com.aluracurso.forohub.domain.curso.validacion;

import com.aluracurso.forohub.domain.curso.DatosCrearCurso;
import com.aluracurso.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValida implements ValidadorCurso{

    @Override
    public void validar(DatosCrearCurso datos) {
        if (datos.categoria() == null) {
            throw new ValidacionDeIntegridad("Debe asignarle una categoria al curso");
        }
        //Validar Enum

    }
}