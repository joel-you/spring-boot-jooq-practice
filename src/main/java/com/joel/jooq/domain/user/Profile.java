package com.joel.jooq.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Embeddable
public class Profile {

    @Embedded
    private UserName userName;

    @Column(name = "bio")
    private String bio;

    @Embedded
    private Image image;

    @Transient
    private boolean following;

}
