package com.prueba.infolaft.domain.estado.gateway;

import com.prueba.infolaft.domain.estado.model.Estado;

import java.util.Optional;

public interface EstadoRepository {

    Estado findByIdNombre(String estado);
}
