package com.prueba.infolaft.application.usecase;

import com.prueba.infolaft.domain.estado.gateway.EstadoRepository;
import com.prueba.infolaft.domain.estado.model.Estado;
import com.prueba.infolaft.domain.task.gateway.TaskRepository;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.domain.task.model.request.TaskUpdate;
import com.prueba.infolaft.domain.task.model.response.TaskResponse;
import com.prueba.infolaft.infrastructure.helper.excepciones.Excepciones;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
class TaskUseCaseImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private EstadoRepository estadoRepository;

    @InjectMocks
    private TaskUseCaseImpl taskUseCase;

    private Task task;

    private Estado estado;

    private TaskUpdate taskUpdate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        estado= new Estado();
        task= new Task();
        taskUpdate=new TaskUpdate();

        estado.setEstadoId(1L);
        estado.setNombreEstado("PENDIENTE");

        task.setEstado(estado);
        task.setTaskId(1L);
        task.setDescripcion("mock");

        taskUpdate.setEstado("PENDIENTE");
        taskUpdate.setDescripcion("mock");




    }

    @Test
    public void findBytaskSucces(){

        when(taskRepository.findByTask(1L)).thenReturn(task);

        Task findtask= taskUseCase.findBytaskResponse(1L);

        assertEquals(1L,findtask.getTaskId());

        verify(taskRepository).findByTask(1L);
    }

    @Test
    public void findByTaskllSucces(){
        List<Task> listaTask=new ArrayList<>();
        listaTask.add(task);
        when(taskRepository.findByAllTask()).thenReturn(listaTask);

        List<Task> taskAll=taskUseCase.findByTaskll();

        assertEquals(1L,taskAll.get(0).getTaskId());

    }

    @Test
    public void findByTaskllEstadoSucces(){
        List<Task> listaTask=new ArrayList<>();
        listaTask.add(task);
        when(estadoRepository.findByIdNombre("PENDIENTE")).thenReturn(estado);
        when(taskRepository.findByAllTaskEstado(1L)).thenReturn(listaTask);

        List<Task> taskAll=taskUseCase.findByTaskllEstado("PENDIENTE");

        assertEquals(1L,taskAll.get(0).getTaskId());

    }

    @Test
    public void addTaskResponseSucces(){
        when(estadoRepository.findByIdNombre("PENDIENTE")).thenReturn(estado);
        when(taskRepository.addTask(task)).thenReturn(task);

        TaskResponse taskResponse = taskUseCase.addTaskResponse(task).get();
        assertEquals(1L,taskResponse.getNTarea());

        verify(taskRepository).addTask(task);
    }

    @Test
    public void updateTaskResponseSucces(){
        when(taskRepository.findByTask(1L)).thenReturn(task);
        when(estadoRepository.findByIdNombre("PENDIENTE")).thenReturn(estado);
        when(taskRepository.addTask(task)).thenReturn(task);

        TaskResponse taskResponse = taskUseCase.updateTaskResponse(1L,taskUpdate).get();

        assertEquals(1L,taskResponse.getNTarea());

    }

    /*@Test
    public void findBytaskNotFound(){
        when(taskRepository.findByTask(2L)).thenReturn(null);

        assertThrows(Excepciones.class,() -> {
            taskUseCase.findBytaskResponse(2L);
        });

        verify(taskRepository).findByTask(2L);
    }*/

}
