package com.github.ioloolo.onlinejudge.domain.contest.controller.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ioloolo.onlinejudge.common.validation.group.NotBlankGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class CreateContestRequest {

    @NotBlank(groups = NotBlankGroup.class, message = "대회 제목은 필수 입력값입니다.")
    @Size(min = 5, max = 50, message = "대회 제목은 5~50자리로 입력해주세요.")
    private String title;

    @NotBlank(groups = NotBlankGroup.class, message = "대회 내용은 필수 입력값입니다.")
    @Size(min = 10, max = 1000, message = "대회 내용은 10~1000자리로 입력해주세요.")
    private String content;

    @NotNull(groups = NotBlankGroup.class, message = "대회 시작시간은 필수 입력값입니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @NotNull(groups = NotBlankGroup.class, message = "대회 종료시간은 필수 입력값입니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
