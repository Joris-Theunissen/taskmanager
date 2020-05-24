package be.ucll.ip.joristheunissen.taskmanager.service;

import be.ucll.ip.joristheunissen.taskmanager.dto.SubTaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ITaskService {
    List<TaskDTO> getTasks();

    TaskDTO getTask(UUID id);

    void createTask(TaskDTO task);

    void editTask(UUID id, TaskDTO TaskDTO);

    void createSubTask(UUID id, SubTaskDTO subTask) throws TaskNotFoundException;

    void deleteAll();
}
