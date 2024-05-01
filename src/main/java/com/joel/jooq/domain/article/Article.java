package com.joel.jooq.domain.article;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.joel.jooq.domain.comment.Comment;
import com.joel.jooq.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "articles")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = EAGER)
    private User author;

    @Embedded
    private ArticleContents contents;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    @JoinTable(name = "article_favorites",
        joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false))
    @ManyToMany(fetch = EAGER, cascade = PERSIST)
    private Set<User> userFavorited = new HashSet<>();

    @OneToMany(mappedBy = "article", cascade = {PERSIST, REMOVE})
    private Set<Comment> comments = new HashSet<>();

    @Transient
    private boolean favorited = false;

}
