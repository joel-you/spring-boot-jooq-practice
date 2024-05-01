package com.joel.jooq.domain.user;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.*;

import java.util.HashSet;
import java.util.Set;

import com.joel.jooq.domain.article.Article;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "users")
@Entity
public class User {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Profile profile;

    @Embedded
    private Password password;

    @JoinTable(name = "user_followings",
        joinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "followee_id", referencedColumnName = "id"))
    @OneToMany(cascade = REMOVE)
    private Set<User> followingUsers = new HashSet<>();

    @ManyToMany(mappedBy = "userFavorited")
    private Set<Article> articleFavorited = new HashSet<>();

}
