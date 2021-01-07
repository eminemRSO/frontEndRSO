package me.eminem.frontEndRSO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
