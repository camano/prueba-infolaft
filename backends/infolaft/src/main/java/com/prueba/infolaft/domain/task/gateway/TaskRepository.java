package com.prueba.infolaft.domain.task.gateway;

import com.prueba.infolaft.domain.estado.model.Estado;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.EstadoEntinty;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task addTask(Task taskNew) ;

    Task findByTask(Long idTask);


    boolean deleteTask(Task task);

    List<Task> findByAllTask();

    List<Task> findByAllTaskEstado(Long estado);



}
