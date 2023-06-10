package com.example.secondhomework.model.users;

import javax.persistence.*;

import com.example.secondhomework.model.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@Entity
@Table(name = "teachers")
@SuperBuilder
@AllArgsConstructor
public class TeacherEntity extends AbstractUserEntity {
}
