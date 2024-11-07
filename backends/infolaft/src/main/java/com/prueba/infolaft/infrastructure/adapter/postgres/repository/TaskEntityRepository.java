package com.prueba.infolaft.infrastructure.adapter.postgres.repository;

import com.prueba.infolaft.infrastructure.adapter.postgres.entity.EstadoEntinty;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskEntityRepository extends JpaRepository<TaskEntity,Long> {

    @Query(value = "SELECT * FROM task where estado_id_task=:estado",nativeQuery = true)
    List<TaskEntity> findByAllEstado(@Param("estado") Long estado);
}
