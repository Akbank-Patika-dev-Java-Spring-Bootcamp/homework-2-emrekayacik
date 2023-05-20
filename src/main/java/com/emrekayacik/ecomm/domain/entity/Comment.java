package com.emrekayacik.ecomm.domain.entity;

import com.emrekayacik.ecomm.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENT_DEF")
@Getter
@Setter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSqGenerator")
    @SequenceGenerator(name = "commentSqGenerator", sequenceName = "SQ_COMMENT",allocationSize = 1)
    private Long id;
    @Column(name = "TEXT", length = 500, nullable = false)
    private String text;
    /*@ManyToOne
    @JoinColumn(name="product_id", nullable=false, referencedColumnName = "id")
    private Product product;*/
    private Long productId;
    private Long userId;
}
