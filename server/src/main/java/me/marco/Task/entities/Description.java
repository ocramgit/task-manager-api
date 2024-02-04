package me.marco.Task.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "description")
public class Description {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @CreationTimestamp
    private Timestamp time_stamp;

    @Column(name = "task_category")
    @JsonProperty("task_category")
    private String task_category;

    public Description(String task_category) {
        this.task_category = task_category;
    }

    public Long getId() {
        return Id;
    }

    public Description() {
    }

    public String getTask_category() {
        return task_category;
    }
}
