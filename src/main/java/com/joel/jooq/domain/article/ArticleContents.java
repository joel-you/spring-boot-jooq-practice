package com.joel.jooq.domain.article;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

import java.util.HashSet;
import java.util.Set;

import com.joel.jooq.domain.tag.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Embeddable
public class ArticleContents {

    @Embedded
    private ArticleTitle title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String body;

    @JoinTable(name = "articles_tags",
        joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false))
    @ManyToMany(fetch = EAGER, cascade = PERSIST)
    private Set<Tag> tags = new HashSet<>();

}
