package com.prueba.infolaft.infrastructure.adapter.postgres.mapper;

import com.prueba.infolaft.domain.estado.model.Estado;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.EstadoEntinty;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RepositoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Task mapEntityTask(TaskEntity taskEntity){
        return this.modelMapper.map(taskEntity, Task.class);
    }

    public TaskEntity mapTask(Task task){
        task.setFechaCreacion(LocalDate.from(LocalDate.now()));
        return this.modelMapper.map(task, TaskEntity.class);
    }

    public Estado mapEntityEstado(EstadoEntinty estadoEntinty){
        return this.modelMapper.map(estadoEntinty, Estado.class);
    }

    public EstadoEntinty mapEstado(Estado estado){
        return this.modelMapper.map(estado, EstadoEntinty.class);
    }

    public Task mapTaskAll(TaskEntity taskEntity){
        return Task.builder()
                .taskId(taskEntity.getTaskId())
                .descripcion(taskEntity.getDescripcion())
                .fechaCreacion(taskEntity.getFechaCreacion())
                .estado(Estado.builder()
                        .estadoId(taskEntity.getEstadoId().getEstadoId())
                        .nombreEstado(taskEntity.getEstadoId().getNombreEstado())
                        .build())
                .build();
    }

}
