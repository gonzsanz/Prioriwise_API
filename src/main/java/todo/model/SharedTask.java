package todo.model;

import jakarta.persistence.*;

@Entity
public class SharedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sharedTask_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public SharedTask () {

    }

    public SharedTask (User user, Task task) {
        super();
        this.user = user;
        this.task = task;
    }

    public Long getSharedTask_id() {
        return sharedTask_id;
    }

public void setSharedTask_id(Long sharedTask_id) {
        this.sharedTask_id = sharedTask_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }



}
