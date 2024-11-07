package com.prueba.infolaft.infrastructure.controller.controller;

import com.prueba.infolaft.application.service.TaskService;
import com.prueba.infolaft.domain.estado.gateway.EstadoRepository;
import com.prueba.infolaft.domain.task.gateway.TaskRepository;
import com.prueba.infolaft.domain.task.model.request.Task;
import com.prueba.infolaft.domain.task.model.request.TaskUpdate;
import com.prueba.infolaft.domain.task.model.response.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /*
    * End point de guardar tarea
    *
    * */

    @Operation(description = "End point para guardar las tareas ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generar la tarea ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
                    }
            )
    })
    @PostMapping
    public ResponseEntity<Optional<TaskResponse>>agregarTarea(@RequestBody Task task){
        return new ResponseEntity<>(taskService.addTaskResponse(task), HttpStatus.OK);
    }


    /*
     * End point para consultar tarea x id
     *
     * */

    @Operation(description = "End point para consultar las tareas  por id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consultar tarea por id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    }
            )
    })
    @GetMapping("/{taskId}")
    public ResponseEntity<?> buscarTarea(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.findBytaskResponse(taskId),HttpStatus.OK);
    }


    /*
     * End point para actualizar la tarea y el estado
     *
     * */

    @Operation(description = "End point para actualizar la tarea y el estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actualizar  tarea x id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
                    }
            )
    })

    @PutMapping("/{taskId}")
    public ResponseEntity<?>actualizarTarea(@PathVariable Long taskId ,@RequestBody TaskUpdate task){
        return new ResponseEntity<>(taskService.updateTaskResponse(taskId,task),HttpStatus.OK);
    }

    /*
     * End point para eliminar la tarea
     *
     * */

    @Operation(description = "End point para eliminar la tarea ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminar   tarea x id ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskResponse.class))
                    }
            )
    })

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?>eliminarTarea(@PathVariable Long taskId){
        return new ResponseEntity<>(taskService.deleteTaskResponse(taskId),HttpStatus.OK);
    }

    /*
     * End point para listar todas  las tareas
     *
     * */

    @Operation(description = "End point para listar todas las tareas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listar todas las tareas ",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    }
            )
    })
    @GetMapping
    public ResponseEntity<?>listarTareas(){
        return new ResponseEntity<>(taskService.findByTaskll(),HttpStatus.OK);
    }


    /*
     * End point para filtrar por estado las tareas
     *
     * */

    @Operation(description = "End point para filtrar por estado las tareas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listar todas las tareas por estado",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
                    }
            )
    })

    @GetMapping("/estado/{estado}")
    public ResponseEntity<?>listarTareasEstado(@PathVariable String estado){
        return new ResponseEntity<>(taskService.findByTaskllEstado(estado),HttpStatus.OK);
    }
}

