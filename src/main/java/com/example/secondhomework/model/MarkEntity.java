package com.example.secondhomework.model;

import com.example.secondhomework.model.enums.MarkEnum;
import com.example.secondhomework.model.users.StudentEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "marks")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MarkEntity extends AbstractEntity{

    @OneToOne
    private TaskEntity task;

    @OneToOne
    private StudentEntity student;

    @Column
    private MarkEnum mark;

}
