package com.example.secondhomework.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MarkEnum {
    FIVE('5'),
    FOUR('4'),
    THREE('3'),
    TWO('2'),
    ONE('1'),
    MISSED('Í'),
    ILL('Á');

    private final char value;
}
