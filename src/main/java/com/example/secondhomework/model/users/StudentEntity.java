package com.example.secondhomework.model.users;

import javax.persistence.*;

import com.example.secondhomework.model.groups.MainGroupEntity;
import com.example.secondhomework.model.groups.SubGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@Entity
@Table(name = "student")
@SuperBuilder
@AllArgsConstructor
public class StudentEntity extends AbstractUserEntity {

}
