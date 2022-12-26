package com.mari.pm.be_template.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseDateAudit {
    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.MIN;
    @LastModifiedDate
    @Column(name = "modify_at", nullable = false)
    private final LocalDateTime modifyAt = LocalDateTime.MIN;
}
