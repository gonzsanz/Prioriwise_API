package prioriwise.service;

import org.springframework.stereotype.Service;
import prioriwise.model.Task;
import prioriwise.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public List<Task> getAllTaskByPriority() {
        return taskRepository.findAllByOrderByPriorityDesc();
    }

    public List<Task> getTasksByPriority(int priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getAllTaskByDueDate() {
        return taskRepository.findAllByOrderByDueDateDesc();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        Task oldTask = taskRepository.findById(task.getTaskId()).orElse(null);
        if (oldTask != null) {
            oldTask.setTitle(task.getTitle());
            oldTask.setDescription(task.getDescription());
            oldTask.setDueDate(task.getDueDate());
            oldTask.setPriority(task.getPriority());
            oldTask.setCompleted(task.isCompleted());
        }
        assert oldTask != null;
        return taskRepository.save(oldTask);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
