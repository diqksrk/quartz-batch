package com.example.demonnn.entity;


import com.example.demonnn.enums.Grade;
import com.example.demonnn.enums.SocialType;
import com.example.demonnn.enums.UserStatus;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, String principle,
                SocialType socialType, UserStatus status, Grade grade, LocalDateTime createdDate,
                LocalDateTime updatedDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.socialType = socialType;
        this.status = status;
        this.grade = grade;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public User setInactive() {
        status = UserStatus.INACTIVE;
        return this;
    }
}
