package be.ucll.ip.joristheunissen.taskmanager;

import be.ucll.ip.joristheunissen.taskmanager.dto.SubTaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.exceptions.TaskNotFoundException;
import be.ucll.ip.joristheunissen.taskmanager.service.ITaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private ITaskService taskService;

    @AfterEach
    public void cleanUp() {
        taskService.deleteAll();
    }

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

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Name");
        taskDTO.setDescription("Description");
        taskDTO.setDate("Tomorrow");
        taskDTO.setId(uuid);
        taskService.createTask(taskDTO);
        // The previous lines are presumed to work if the previous test succeeded; the tests do not share data however.
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
