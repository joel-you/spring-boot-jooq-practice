package com.joel.jooq.domain.article;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Embeddable
public class ArticleTitle {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String slug;

}
