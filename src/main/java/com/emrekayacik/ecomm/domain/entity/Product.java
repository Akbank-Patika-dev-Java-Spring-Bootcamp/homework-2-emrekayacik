package com.emrekayacik.ecomm.domain.entity;

import com.emrekayacik.ecomm.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "PRODUCT_DEF")
@Getter
@Setter
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSqGenerator")
    @SequenceGenerator(name = "productSqGenerator", sequenceName = "SQ_PRODUCT",allocationSize = 1)
    private Long id;
    @Column(name = "NAME", length = 70, nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    @Column(name = "PRICE", nullable = false)
    private double price;
//    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,mappedBy = "product",targetEntity = Comment.class)
//    private Set<Comment> comments;
}
