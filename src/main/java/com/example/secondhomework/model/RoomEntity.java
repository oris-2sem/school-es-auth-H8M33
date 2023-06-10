package com.example.secondhomework.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table (name = "room")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity extends AbstractEntity{

    @Column (unique = true)
    private String roomNumber;

}
