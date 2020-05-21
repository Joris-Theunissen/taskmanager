package be.ucll.ip.joristheunissen.taskmanager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Task extends SuperTask {
    private String date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // TODO: Ask why it doesn't initialize during tests
    private List<SubTask> subtasks = new ArrayList<>();

    public Task() { }

    public Task(String name, String description, String date) {
        super(name, description);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void addSubTask(SubTask sub) {
        subtasks.add(sub);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SubTask> getSubTasks() {
        return subtasks;
    }
}
