package me.marco.Task.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import me.marco.Task.entities.Description;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
@Table(name = "\"tasks\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String task;

    @ManyToOne(cascade = CascadeType.ALL)
    private Description description;

    public Task(Long id, String task, Description description) {
        Id = id;
        this.task = task;
        this.description = description;
    }

    public Task(String task, Description description) {
        this.task = task;
        this.description = description;
    }

    public Task() {
    }

    public Long getId() {
        return Id;
    }

    public String getTask() {
        return task;
    }

    public Description getDescription() {
        return description;
    }
}
