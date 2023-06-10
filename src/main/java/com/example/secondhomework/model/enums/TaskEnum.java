package com.example.secondhomework.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskEnum {
    CONTROL_WORK("Контрольная работа"),
    WORK_ON_LESSON("Ответ на уроке"),
    PRESENTATION("Доклад"),
    HOMEWORK("Домашня работа");

    private final String value;
}
