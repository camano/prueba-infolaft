package com.prueba.infolaft.infrastructure.helper.excepciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MensajeException {
    private String mensaje;
}
