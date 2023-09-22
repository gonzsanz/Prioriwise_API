package prioriwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prioriwise.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTitle(final String title);
    List<Task> findAllByOrderByPriorityDesc();
    List<Task> findByPriority(int priority);
    List<Task> findAllByOrderByDueDateDesc();

}
