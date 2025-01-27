package be.ucll.ip.joristheunissen.taskmanager.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class SuperTask {
    @Id
    //@GeneratedValue
    // While the previous line is "correct"; it makes testing harder. So we'll do it the manual way for now
    private UUID id = UUID.randomUUID();
    private String name, description;

    public SuperTask() { }

    public SuperTask(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public SuperTask(String name, String description, UUID id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
