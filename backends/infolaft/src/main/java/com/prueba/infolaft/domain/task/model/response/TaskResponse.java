package com.prueba.infolaft.domain.task.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {

    private String mensaje;
    private Long nTarea;
}
