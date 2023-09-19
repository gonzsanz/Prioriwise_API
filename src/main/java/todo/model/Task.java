package todo.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "dueDate", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "priority", nullable = false)
    private int priority;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



    public Task () {

    }

    public Task (String title, String description, LocalDateTime dueDate, boolean completed, int priority, User user) {
        super();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.priority = priority;
        this.user = user;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    @PrePersist
    public void setDueDate() {
        this.dueDate = LocalDateTime.now();
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
