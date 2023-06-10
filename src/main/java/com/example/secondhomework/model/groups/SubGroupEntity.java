package com.example.secondhomework.model.groups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sub_group")
@SuperBuilder
@AllArgsConstructor
public class SubGroupEntity extends AbstractGroupEntity {
}
