package be.ucll.ip.joristheunissen.taskmanager;

import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    @Test
    public void testGetTasks() {
        // setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setName("Naam");
        taskDTO.setDate("Morgen");
        taskDTO.setDescription("");
    }
}
