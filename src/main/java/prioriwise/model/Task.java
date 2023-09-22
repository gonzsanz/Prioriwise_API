package prioriwise.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
