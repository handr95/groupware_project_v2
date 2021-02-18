package com.sgw.common.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskState {
    NEW(1, "신규"),
    PROGRESS(2, "진행"),
    COMPLETED(3, "완료");

    private final Integer key;
    private final String title;
}