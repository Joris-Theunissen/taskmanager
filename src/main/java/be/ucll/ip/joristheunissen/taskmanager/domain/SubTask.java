package be.ucll.ip.joristheunissen.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SubTask extends SuperTask {

    public SubTask(String name, String description) {
        super(name, description);
    }

    public SubTask() { }
}
