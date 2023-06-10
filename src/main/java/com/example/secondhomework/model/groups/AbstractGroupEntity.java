package com.example.secondhomework.model.groups;

import com.example.secondhomework.model.AbstractEntity;
import com.example.secondhomework.model.users.StudentEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractGroupEntity extends AbstractEntity {

    @ManyToMany
    private Set<StudentEntity> students;

    @Column
    private String grade;
}
