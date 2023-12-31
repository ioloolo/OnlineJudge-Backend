package com.github.ioloolo.onlinejudge.domain.user.controller.payload.request;

import com.github.ioloolo.onlinejudge.common.validation.group.LengthGroup;
import com.github.ioloolo.onlinejudge.common.validation.group.NotBlankGroup;
import com.github.ioloolo.onlinejudge.common.validation.group.PatternGroup;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateUserRequest {

    @NotBlank(groups = NotBlankGroup.class, message = "유저 ID는 필수 입력값입니다.")
    private String userId;

    @NotBlank(groups = NotBlankGroup.class, message = "이름은 필수 입력값입니다.")
    @Size(min = 2, max = 24, groups = LengthGroup.class, message = "이름은 2자 이상 24자 이하로 입력해주세요.")
    private String name;

    @Nullable
    @Size(min = 8, max = 32, groups = LengthGroup.class, message = "비밀번호는 8자 이상 32자 이하로 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$", groups = PatternGroup.class, message = "비밀번호는 영문, 숫자를 포함해야 합니다.")
    private String password;
}
