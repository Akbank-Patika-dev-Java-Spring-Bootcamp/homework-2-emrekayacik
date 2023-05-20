package com.emrekayacik.ecomm.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class BaseAuditableEntity {
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "ID_CREATED_USER")
    private Long createdUser;
    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
    @Column(name = "ID_MODIFIED_USER")
    private Long modifiedUser;
}
