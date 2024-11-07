package com.prueba.infolaft.domain.task.usecase;

import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.domain.task.model.request.TaskUpdate;
import com.prueba.infolaft.domain.task.model.response.TaskResponse;

import java.util.List;
import java.util.Optional;

public interface TaskUseCase {

    Optional<TaskResponse> addTaskResponse(Task task);

    Task findBytaskResponse(Long taskId);

    Optional<TaskResponse> updateTaskResponse(Long taskId, TaskUpdate task);

    Optional<TaskResponse> deleteTaskResponse(Long taskId);

    List<Task> findByTaskll();

    List<Task> findByTaskllEstado(String estado);

}
