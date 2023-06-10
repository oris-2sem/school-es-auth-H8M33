package com.example.secondhomework.model;

import javax.persistence.*;

import com.example.secondhomework.model.users.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@Entity
@SuperBuilder
@Table (name = "Subject")
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity extends AbstractEntity {

    @Column(unique = true)
    private String title;

    @ManyToMany
    @JoinTable(
            name = "subject_teacher",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<TeacherEntity> teachers;
}
