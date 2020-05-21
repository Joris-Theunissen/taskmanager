package be.ucll.ip.joristheunissen.taskmanager.controller;

import be.ucll.ip.joristheunissen.taskmanager.dto.SubTaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.dto.TaskDTO;
import be.ucll.ip.joristheunissen.taskmanager.exceptions.TaskNotFoundException;
import be.ucll.ip.joristheunissen.taskmanager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class TaskController {
    private final ITaskService taskService;

    // Constructor-based dependency injection instead of field-based, see https://blog.marcnuri.com/field-injection-is-not-recommended/
    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasksList(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getSpecificTask(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("task", taskService.getTask(id));
        return "task";
    }

    @GetMapping("/tasks/new")
    public String getCreateTaskForm(Model model) {
        model.addAttribute("edit", false);
        model.addAttribute("task", new TaskDTO());
        return "taskform";
    }

    @PostMapping("/tasks/create")
    public String postCreateTask(Model model, @Valid @ModelAttribute TaskDTO task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditTask(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("edit", true);
        model.addAttribute("task", taskService.getTask(id));
        return "taskform";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable("id") UUID id, @Valid @ModelAttribute TaskDTO taskDTO) {
        taskService.editTask(id, taskDTO);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getCreateSub(Model model, @PathVariable(value = "id") UUID id) {
        model.addAttribute("id", id);
        model.addAttribute("edit", false);
        model.addAttribute("subtask", new SubTaskDTO());
        return "subtaskform";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String createSub(@PathVariable(value = "id") UUID id, @Valid @ModelAttribute SubTaskDTO subTask) throws TaskNotFoundException {
        taskService.createSubTask(id, subTask);
        return "redirect:/tasks/{id}";
    }
}
