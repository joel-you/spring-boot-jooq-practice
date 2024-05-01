package com.joel.jooq.domain.tag;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "tags")
@Entity
public class Tag {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Column(name = "tag_value", unique = true, nullable = false)
    private String value;

}
