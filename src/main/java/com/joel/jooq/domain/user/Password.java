package com.joel.jooq.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Embeddable
class Password {

    @Column(name = "password", nullable = false)
    private String encodedPassword;

}
