package com.example.secondhomework.model.groups;

import com.example.secondhomework.model.users.TeacherEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "main_group")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainGroupEntity extends AbstractGroupEntity {

    @OneToOne
    private TeacherEntity classroomTeacher;

    @Column
    private char type;
}
