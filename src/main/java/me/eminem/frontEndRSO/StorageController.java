package me.eminem.frontEndRSO;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class StorageController {

    TaskService taskService;

    ModelMapper modelMapper;

    public StorageController(TaskService taskService) {
        modelMapper = new ModelMapper();
        this.taskService = taskService;
    }



    @GetMapping(path="/tasks")
    public Stream<TaskDTO> getAllTasks(){
        return taskService.getAllTasks().stream().map(task -> modelMapper.map(task,TaskDTO.class));
    }
}