package com.aluracurso.forohub.domain.curso.validacion;

import com.aluracurso.forohub.domain.curso.CursoRepository;
import com.aluracurso.forohub.domain.curso.DatosCrearCurso;
import com.aluracurso.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoExistenteValidacionCurso implements ValidadorCurso{

    @Autowired
    CursoRepository repository;

    @Override
    public void validar(DatosCrearCurso datos) {
        if (repository.existsByNombre(datos.nombre())) {
            throw new ValidationException("Ya existe un curso con ese nombre");
        }
        if (datos.nombre() == null) {
            throw new ValidacionDeIntegridad("El nombre del curso no puede quedar vacio");
        }
    }
}
