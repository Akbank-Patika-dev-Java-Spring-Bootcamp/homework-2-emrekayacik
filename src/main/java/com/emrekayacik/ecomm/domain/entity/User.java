package com.emrekayacik.ecomm.domain.entity;

import com.emrekayacik.ecomm.base.entity.BaseEntity;
import com.emrekayacik.ecomm.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER_DEF")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSqGenerator")
    @SequenceGenerator(name = "userSqGenerator", sequenceName = "SQ_USER",allocationSize = 1)
    private Long id;
    @Column(name = "USERNAME",length = 50 , nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD",length = 100 , nullable = false)
    private String password;
    @Column(name = "NAME",length = 100 , nullable = false)
    private String name;
    @Column(name = "SURNAME",length = 100)
    private String surname;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name = "TYPE",length = 20 , nullable = false)
    private UserType type;
    @Column(name = "EMAIL",nullable = false,length = 100,unique = true)
    private String email;
    @Column(name = "ADDRESS",nullable = false,length = 250)

    private String address;
    @Column(name = "PHONE_NUMBER",nullable = false,length = 50,unique = true)
    private String phoneNumber;

}
