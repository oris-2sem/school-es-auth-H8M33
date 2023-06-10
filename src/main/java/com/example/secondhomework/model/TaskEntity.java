package com.example.secondhomework.model;

import com.example.secondhomework.model.enums.TaskEnum;
import com.example.secondhomework.model.users.StudentEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity extends AbstractEntity{

    @ManyToMany
    @JoinTable(
        name ="student_task",
        joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<StudentEntity> students;

    @ManyToOne
    private LessonEntity lesson;

    private TaskEnum taskType;
}
