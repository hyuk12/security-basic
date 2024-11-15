package com.security.basic.web.api.member.dto.request;

import com.security.basic.domain.member.entity.Member;
import com.security.basic.domain.member.enums.AuthType;
import com.security.basic.domain.member.enums.Gender;
import com.security.basic.domain.member.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MemberCreateRequestDto(
    @NotBlank
    String email,
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()-+=]).{8,}$")
    String password,
    @NotBlank
    String name,
    String gender,
    String phoneNumber
) {
    public Member of(String password) {
        return Member.builder()
            .email(email)
            .name(name)
            .password(password)
            .phoneNumber(phoneNumber)
            .gender(Gender.valueOf(gender))
            .role(Role.valueOf("USER"))
            .authType(AuthType.valueOf("COMMON"))
            .build();
    }
}
