package com.prueba.infolaft.infrastructure.adapter.postgres.respositoreyAdapter;

import com.prueba.infolaft.domain.estado.gateway.EstadoRepository;
import com.prueba.infolaft.domain.estado.model.Estado;
import com.prueba.infolaft.infrastructure.adapter.postgres.mapper.RepositoryMapper;
import com.prueba.infolaft.infrastructure.adapter.postgres.repository.EstadoEntityRepository;
import com.prueba.infolaft.infrastructure.helper.excepciones.Excepciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoRepositoryAdapter implements EstadoRepository {


    @Autowired
    private EstadoEntityRepository estadoEntityRepository;

    @Autowired
    private RepositoryMapper repositoryMapper;


    @Override
    public Estado findByIdNombre(String estado) {
        return estadoEntityRepository.estadoId(estado)
                .map(estadoEntinty -> repositoryMapper.mapEntityEstado(estadoEntinty))
                .orElseThrow(() -> new Excepciones("No se encontro ese nombre estado "));
    }
}
