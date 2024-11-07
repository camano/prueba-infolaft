package com.prueba.infolaft.application.usecase;

import com.prueba.infolaft.domain.estado.gateway.EstadoRepository;
import com.prueba.infolaft.domain.estado.model.Estado;
import com.prueba.infolaft.domain.task.gateway.TaskRepository;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.domain.task.model.request.TaskUpdate;
import com.prueba.infolaft.domain.task.model.response.TaskResponse;
import com.prueba.infolaft.domain.task.usecase.TaskUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskUseCaseImpl implements TaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public Optional<TaskResponse> addTaskResponse(Task task) {
        Estado estado = estadoRepository.findByIdNombre("PENDIENTE");
        task.setEstado(estado);
        return Optional.of(taskRepository.addTask(task))
                .map(task1 -> TaskResponse.builder().nTarea(task1.getTaskId()).mensaje("Se creo la tarea "+ task1.getDescripcion()).build());
    }

    @Override
    public Task findBytaskResponse(Long taskId) {
        return taskRepository.findByTask(taskId);
    }

    @Override
    public Optional<TaskResponse> updateTaskResponse(Long taskId, TaskUpdate task) {
        Task updateTask = taskRepository.findByTask(taskId);
        Estado estado = estadoRepository.findByIdNombre(task.getEstado());
        updateTask.setDescripcion(task.getDescripcion());
        updateTask.setEstado(estado);
        return Optional.of(taskRepository.addTask(updateTask))
                .map(task1 -> TaskResponse.builder().nTarea(task1.getTaskId()).mensaje("se actualizo la tarea  "+ task1.getDescripcion()).build());
    }

    @Override
    public Optional<TaskResponse> deleteTaskResponse(Long taskId) {
        Task deleletask = taskRepository.findByTask(taskId);
        return Optional.of(taskRepository.deleteTask(deleletask))
                .map(aBoolean -> {
                    if(aBoolean){
                        return TaskResponse.builder().nTarea(taskId).mensaje("se elimino la tarea  ").build();
                    }else{
                        return TaskResponse.builder().nTarea(taskId).mensaje("No se pudo eliminar la tarea  "+ deleletask.getDescripcion()).build();
                    }
                });
    }

    @Override
    public List<Task> findByTaskll() {
        return taskRepository.findByAllTask();
    }

    @Override
    public List<Task> findByTaskllEstado(String estado) {
        Estado idEstado = estadoRepository.findByIdNombre(estado);
        return taskRepository.findByAllTaskEstado(idEstado.getEstadoId());
    }


}
