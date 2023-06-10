package com.example.secondhomework.model;

import com.example.secondhomework.model.groups.MainGroupEntity;
import com.example.secondhomework.model.groups.SubGroupEntity;
import com.example.secondhomework.model.users.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "lesson")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LessonEntity extends AbstractEntity{

    @Column(nullable = false)
    private LocalDateTime start_time;

    @Column(nullable = false)
    private LocalDateTime end_time;

    @OneToOne
    private SubjectEntity subject;

    @ManyToMany
    @JoinTable(name = "lesson_main_group",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns =@JoinColumn(name = "group_id")
    )
    private Set<MainGroupEntity> mainGroups;

    @ManyToMany
    @JoinTable(name = "lesson_sub_group",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns =@JoinColumn(name = "group_id")
    )
    private Set<SubGroupEntity> subGroups;

    @ManyToOne
    private TeacherEntity teacher;

    @ManyToOne
    private RoomEntity room;
}
