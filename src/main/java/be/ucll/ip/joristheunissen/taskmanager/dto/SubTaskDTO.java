package be.ucll.ip.joristheunissen.taskmanager.dto;

import javax.validation.constraints.NotNull;

public class SubTaskDTO {
    @NotNull
    private String name, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
