package com.prueba.infolaft.domain.estado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estado {

    private Long estadoId;

    private String nombreEstado;
}
