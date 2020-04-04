/*
package be.ucll.ip.joristheunissen.taskmanager.service;

import be.ucll.ip.joristheunissen.taskmanager.domain.SubTask;
import be.ucll.ip.joristheunissen.taskmanager.domain.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskServiceInMemory implements ITaskService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private static int idCount = 0;

    public TaskServiceInMemory() {
        tasks.put(idCount++, new Task("Task 1", "Dit is de eerste taak", "March 20 2020 at 10 am"));
        tasks.put(idCount++, new Task("Task 2", "Dit is de tweede taak", "March 21 2020 at 6 pm"));
        tasks.put(idCount++, new Task("Task 3", "Dit is de derde taak", "March 27 2020 at 5 pm"));
    }

    @Override
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public Task getTask(int id) {
        return tasks.get(id);
    }

    @Override
    public void createTask(String name, String description, String date) {
        tasks.put(idCount++, new Task(name, description, date));
    }

    @Override
    public void editTask(int id, String name, String description, String date) {
        tasks.put(id, new Task(name, description, date));
    }

    @Override
    public void createSubTask(int id, String name, String description) {
        tasks.get(id).addSubTask(new SubTask(name, description));
    }
}
*/
