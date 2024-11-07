package com.prueba.infolaft.infrastructure.adapter.postgres.repository;

import com.prueba.infolaft.infrastructure.adapter.postgres.entity.EstadoEntinty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoEntityRepository extends JpaRepository<EstadoEntinty,Long> {

    @Query(value = "SELECT * FROM ESTADO WHERE nombre_estado=:nombreEstado",nativeQuery = true)
    Optional<EstadoEntinty> estadoId(@Param("nombreEstado") String nombreEstado);
}
