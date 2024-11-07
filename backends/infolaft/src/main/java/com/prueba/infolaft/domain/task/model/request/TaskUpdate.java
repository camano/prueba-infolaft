package com.prueba.infolaft.domain.task.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUpdate {

    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;
}
