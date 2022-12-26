package com.mari.pm.be_template.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ocean")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ocean extends BaseDateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(nullable = false)
    private String name = "";

    @Column
    private boolean visited = false;

    @Builder
    public Ocean(String name, boolean visited) {
        this.name = name;
        this.visited = visited;
    }
}
