package com.github.ioloolo.onlinejudge.domain.problem.controller.payload.request;

import com.github.ioloolo.onlinejudge.common.validation.group.NotBlankGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddLectureProblemRequest {

    @NotBlank(groups = NotBlankGroup.class, message = "수업 ID는 필수 입력값입니다.")
    private String lectureId;

    @NotBlank(groups = NotBlankGroup.class, message = "문제 ID는 필수 입력값입니다.")
    private String problemId;
}