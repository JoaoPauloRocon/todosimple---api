package com.joaopaulorocon.todosimple.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = Task.TABLE_NAME)

public class Task {
    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "descripition", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String descripition;


    public Task() {
    }

    public Task(Long id, User user, String descripition) {
        this.id = id;
        this.user = user;
        this.descripition = descripition;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescripition() {
        return this.descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Task)) {
            return false;
        }
        Task task = (Task) obj;
        return Objects.equals(id, task.id) && Objects.equals(user, task.user) && Objects.equals(descripition, task.descripition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, descripition);
    }


}
