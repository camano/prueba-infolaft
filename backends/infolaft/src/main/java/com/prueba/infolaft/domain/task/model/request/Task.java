package com.prueba.infolaft.domain.task.model.request;

import com.prueba.infolaft.domain.estado.model.Estado;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private Long taskId;
    private String descripcion;
    private LocalDate fechaCreacion;

    private Estado estado;
}
