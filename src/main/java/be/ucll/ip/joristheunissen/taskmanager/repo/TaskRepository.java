package be.ucll.ip.joristheunissen.taskmanager.repo;

import be.ucll.ip.joristheunissen.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface TaskRepository extends JpaRepository<Task, UUID> {

}
