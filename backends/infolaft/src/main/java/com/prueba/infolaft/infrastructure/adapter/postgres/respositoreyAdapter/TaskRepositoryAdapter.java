package com.prueba.infolaft.infrastructure.adapter.postgres.respositoreyAdapter;

import com.prueba.infolaft.domain.task.gateway.TaskRepository;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.EstadoEntinty;
import com.prueba.infolaft.infrastructure.adapter.postgres.entity.TaskEntity;
import com.prueba.infolaft.infrastructure.adapter.postgres.mapper.RepositoryMapper;
import com.prueba.infolaft.infrastructure.adapter.postgres.repository.EstadoEntityRepository;
import com.prueba.infolaft.infrastructure.adapter.postgres.repository.TaskEntityRepository;
import com.prueba.infolaft.infrastructure.helper.excepciones.Excepciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskRepositoryAdapter implements TaskRepository {

    @Autowired
    private TaskEntityRepository taskEntityRepository;


    @Autowired
    private RepositoryMapper repositoryMapper;

    @Override
    public Task addTask(Task taskNew) {

        try{
            TaskEntity newTask = taskEntityRepository.save(repositoryMapper.mapTask(taskNew));
            return repositoryMapper.mapEntityTask(newTask);
        }catch (DataAccessException e){
            throw new Excepciones("Hubo un error al general la tarea " +e.getMessage());
        }

    }

    @Override
    public Task findByTask(Long idTask) {
        return taskEntityRepository.findById(idTask).map(taskEntity -> repositoryMapper.mapTaskAll(taskEntity))
                .orElseThrow(() -> new Excepciones("No se encontro la tarea "));
    }


    @Override
    public boolean deleteTask(Task task) {
        try {
            if(!equals(task)){
                taskEntityRepository.delete(repositoryMapper.mapTask(task));
                return true;
            }else {
                return false;
            }
        }catch (DataAccessException e){
            throw new Excepciones("Hubo un problema al eliminar la tarea ");
        }

    }

    @Override
    public List<Task> findByAllTask() {
        return taskEntityRepository.findAll()
                .stream()
                .map(taskEntity -> repositoryMapper.mapTaskAll(taskEntity))
                .toList();
    }

    @Override
    public List<Task> findByAllTaskEstado(Long estado) {
        return taskEntityRepository.findByAllEstado(estado)
                .stream()
                .map(taskEntity -> repositoryMapper.mapTaskAll(taskEntity))
                .toList();
    }


}
