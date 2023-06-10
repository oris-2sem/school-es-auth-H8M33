package com.example.secondhomework.service;

import com.example.secondhomework.dto.request.LessonRequest;
import com.example.secondhomework.dto.response.LessonResponse;
import com.example.secondhomework.model.LessonEntity;
import com.example.secondhomework.repository.*;
import com.example.secondhomework.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository repository;

    private final RoomService roomService;

    private final SubjectService subjectService;

    private final TeacherService teacherService;

    private final MainGroupService mainGroupService;

    private final SubGroupService subGroupService;


    @Override
    public List<LessonResponse> getAllLessons() {
        return repository.findAll().stream().map(
                x -> LessonResponse.builder()
                        .id(x.getId())
                        .subject(x.getSubject().getTitle())
                        .start_time(x.getStart_time().toString())
                        .end_time(x.getEnd_time().toString())
                        .room_number(x.getRoom().getRoomNumber())
                        .teacher_username(x.getTeacher().getUsername())
                        .build()
        ).toList();
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void createLesson(LessonRequest request) {
        repository.save(createEntityFromRequest(request)
        );
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void updateLesson(UUID lessonId, LessonRequest request) {
        LessonEntity toUpdate = repository.findById(lessonId).orElseThrow(RuntimeException::new);
        LessonEntity entity = createEntityFromRequest(request);
        toUpdate.setRoom(entity.getRoom());
        toUpdate.setSubject(entity.getSubject());
        toUpdate.setTeacher(entity.getTeacher());
        toUpdate.setStart_time(entity.getStart_time());
        toUpdate.setEnd_time(entity.getEnd_time());
        toUpdate.setMainGroups(entity.getMainGroups());
        toUpdate.setSubGroups(entity.getSubGroups());
        repository.save(toUpdate);
    }

    private LessonEntity createEntityFromRequest(LessonRequest request){
        return LessonEntity.builder()
                .room(roomService.getByRoomNumber(request.getRoom_number()))
                .subject(subjectService.getByTitle(request.getSubject()))
                .start_time(LocalDateTime.parse(request.getStart_time().toString()))
                .end_time(LocalDateTime.parse(request.getEnd_time().toString()))
                .teacher(teacherService.getByUsername(request.getTeacher_username()))
                .mainGroups(request.getMainGroupId().stream().map(mainGroupService::getById).collect(Collectors.toSet()))
                .subGroups(request.getMainGroupId().stream().map(subGroupService::getById).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public LessonResponse getLesson(UUID lessonId) {
        return repository.findById(lessonId).map(x -> LessonResponse.builder()
                .id(x.getId())
                .subject(x.getSubject().getTitle())
                .start_time(x.getStart_time().toString())
                .end_time(x.getEnd_time().toString())
                .room_number(x.getRoom().getRoomNumber())
                .teacher_username(x.getTeacher().getUsername())
                .build()
        ).orElseThrow(RuntimeException::new);
    }

    @Override
    @PreAuthorize("hasAuthority('TEACHER')")
    public void deleteLesson(UUID lessonId) {
        repository.deleteById(lessonId);
    }

    @Override
    public LessonEntity getLessonEntity(UUID lesson_id) {
        return repository.findById(lesson_id).orElseThrow(RuntimeException::new);
    }
}
