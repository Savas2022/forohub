package com.aluracurso.forohub.domain.topico;

import com.aluracurso.forohub.domain.repuesta.DatosRespuesta;
import org.springframework.data.domain.Page;

public record DatosTopicoRespuestas(DatosTopico topico, Page<DatosRespuesta> respuestas) {
}
