package be.ucll.ip.joristheunissen.taskmanager;

import be.ucll.ip.joristheunissen.taskmanager.domain.Task;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TaskUnitTest {
    @Test
    public void testTaskConstructor() {
        // No setup for this one
        // Method to be tested
        Task task = new Task("Naam", "Omschrijving", "Datum");
        // Checks
        assertEquals("Naam", task.getName());
        assertEquals("Omschrijving", task.getDescription());
        assertEquals("Datum", task.getDate());
    }

    @Test
    public void testTaskNameSetter() {
        Task task = new Task();
        // Method to be tested
        task.setName("Naam");
        // Checks
        assertEquals("Naam", task.getName());
    }

    @Test
    public void testTaskDescriptionSetter() {
        Task task = new Task();
        // Method to be tested
        task.setDescription("Omschrijving");
        // Checks
        assertEquals("Omschrijving", task.getDescription());
    }

    @Test
    public void testTaskDateSetter() {
        Task task = new Task();
        // Method to be tested
        task.setDate("Datum");
        // Checks
        assertEquals("Datum", task.getDate());
    }

    @Test
    public void testTaskIdSetter() {
        UUID uuid = UUID.randomUUID();
        Task task = new Task();
        // Method to be tested
        task.setId(uuid);
        // Checks
        assertEquals(uuid, task.getId());
    }
}
