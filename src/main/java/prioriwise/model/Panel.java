package prioriwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long panel_id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToMany
    @JoinColumn(name = "user_id", nullable = false)
    private List<User> users;

    @Column(name = "shared", nullable = false)
    private boolean shared;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;


}
