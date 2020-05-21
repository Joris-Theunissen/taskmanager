package be.ucll.ip.joristheunissen.taskmanager;

import be.ucll.ip.joristheunissen.taskmanager.domain.Task;
import be.ucll.ip.joristheunissen.taskmanager.dto.SubTaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.exceptions.TaskNotFoundException;
import be.ucll.ip.joristheunissen.taskmanager.repo.TaskRepository;
import be.ucll.ip.joristheunissen.taskmanager.service.ITaskService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private ITaskService taskService;

    //For the second test only
    @Autowired
    private TaskRepository repository;

    @Test
    public void testGetTasks() {
        // setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Naam");
        taskDTO.setDate("Morgen");
        taskDTO.setDescription("Beschrijving");
        taskService.createTask(taskDTO);

        // method to be tested
        List<TaskDTO> tasks = taskService.getTasks();

        // checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        TaskDTO task = tasks.get(0);
        assertNotNull(task);
    }

    @Test
    public void testGetSubTasks() {
        UUID uuid = UUID.randomUUID();
        Task task = new Task();
        task.setName("Name");
        task.setDescription("Description");
        task.setDate("Tomorrow");
        task.setId(uuid);
        repository.save(task);
        // setup
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setName("Ook een naam");
        subTaskDTO.setDescription("Ook een beschrijving");
        try {
            taskService.createSubTask(uuid, subTaskDTO);
        } catch (TaskNotFoundException e) {
            fail();
        }
        // method to be tested
        List<SubTaskDTO> subTasks = taskService.getTask(uuid).getSubTasks();

        assertNotNull(subTasks);
        assertFalse(subTasks.isEmpty());
        assertEquals(1, subTasks.size());
        SubTaskDTO subTask = subTasks.get(0);
        assertNotNull(subTask);
    }
}
