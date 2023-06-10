package com.example.secondhomework.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parents")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ParentEntity extends AbstractUserEntity {

    @OneToOne
    StudentEntity student;

}
