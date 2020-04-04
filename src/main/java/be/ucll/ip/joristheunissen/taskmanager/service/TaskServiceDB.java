package be.ucll.ip.joristheunissen.taskmanager.service;

import be.ucll.ip.joristheunissen.taskmanager.domain.SubTask;
import be.ucll.ip.joristheunissen.taskmanager.domain.Task;
import be.ucll.ip.joristheunissen.taskmanager.dto.SubTaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.repo.TaskRepository;
import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceDB implements ITaskService {
    @Autowired
    private TaskRepository repo;

    @Override
    public List<TaskDTO> getTasks() {
        return repo.findAll().stream().map(x -> {
            TaskDTO t = new TaskDTO();
            t.setName(x.getName());
            t.setDescription(x.getDescription());
            t.setDate(x.getDate());
            t.setId(x.getId());
            return t;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(UUID id) {
        return repo.findById(id).map(x -> {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setName(x.getName());
            taskDTO.setDescription(x.getDescription());
            taskDTO.setDate(x.getDate());
            taskDTO.setId(x.getId());
            taskDTO.setSubTasks(x.getSubTasks().stream().map(y -> {
                SubTaskDTO subTaskDTO = new SubTaskDTO();
                subTaskDTO.setName(y.getName());
                subTaskDTO.setDescription(y.getDescription());
                return subTaskDTO;
            }).collect(Collectors.toList()));
            return taskDTO;
        }).orElse(null);
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), taskDTO.getDate());
        repo.save(task);
    }

    @Override
    public void editTask(UUID id, TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), taskDTO.getDate());
        task.setId(id);
        repo.save(task);
    }

    @Override
    public void createSubTask(UUID id, SubTaskDTO subTaskDTO) {
        Task task = repo.findById(id).get();
        SubTask subTask = new SubTask(subTaskDTO.getName(), subTaskDTO.getDescription());
        task.addSubTask(subTask);
        repo.save(task);
    }
}
