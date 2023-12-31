package com.github.ioloolo.onlinejudge.domain.user.data;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@Document
public class Role {

    @Id
    private final String id;

    private final Roles role;

    public enum Roles {
        ROLE_USER, ROLE_ADMIN
    }
}
