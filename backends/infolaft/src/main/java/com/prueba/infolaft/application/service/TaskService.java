package com.prueba.infolaft.application.service;

import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.domain.task.model.request.TaskUpdate;
import com.prueba.infolaft.domain.task.model.response.TaskResponse;
import com.prueba.infolaft.domain.task.usecase.TaskUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskUseCase {

    @Autowired
    private TaskUseCase taskUseCase;


    @Override
    public Optional<TaskResponse> addTaskResponse(Task task) {
        return taskUseCase.addTaskResponse(task);
    }

    @Override
    public Task findBytaskResponse(Long taskId) {
        return taskUseCase.findBytaskResponse(taskId);
    }


    @Override
    public Optional<TaskResponse> updateTaskResponse(Long taskId, TaskUpdate task) {
        return taskUseCase.updateTaskResponse(taskId,task);
    }

    @Override
    public Optional<TaskResponse> deleteTaskResponse(Long taskId) {
        return taskUseCase.deleteTaskResponse(taskId);
    }

    @Override
    public List<Task> findByTaskll() {
        return taskUseCase.findByTaskll();
    }

    @Override
    public List<Task> findByTaskllEstado(String estado) {
        return taskUseCase.findByTaskllEstado(estado);
    }


}
