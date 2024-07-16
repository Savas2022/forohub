package com.aluracurso.forohub.domain.curso;

import com.aluracurso.forohub.domain.topico.DatosTopico;
import org.springframework.data.domain.Page;

public record DatosCursoTopicos(DatosCurso curso, Page<DatosTopico> topicos) {

}
