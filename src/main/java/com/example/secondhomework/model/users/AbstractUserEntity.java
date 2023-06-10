package com.example.secondhomework.model.users;

import com.example.secondhomework.model.AbstractEntity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractUserEntity extends AbstractEntity {

    @Column (nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    private String hashPassword;

    @Column (nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private String role;

}
