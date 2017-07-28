package com.example.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER", uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "SeqBoUser", sequenceName = "SEQ_TBU_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqBoUser")
    @Column(name = "USER_ID", nullable = false, length = 19)
    private Long userId;

    // 사용자 ID - Unique
    @Column(name = "USERNAME", nullable = false, length = 64)
    private String username;

    // Unique
//    private String account;

    // 
    @Column(name = "PASSWORD", nullable = false, length = 64)
    private String password;

    //
    // N:1 / Mandatory Non-identifying / Outer join
    @JoinColumn(name = "ROLE_ID", nullable = false)
    @ManyToOne
    private Role role;
    //    private String permission;

//    private String group;

    // 
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FULL_NAME")
    private String fullName;

    private String authSession;
    private String authToken;

    private Integer failCnt;   // until 5

    @Column(name = "LOCKED", length = 1)
    private String locked;  // Y/N

    /*
    // 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    //
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessedAt;

    //
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedPasswordAt;

    // 업무 그룹
    // - 시스템관리자, MD, AMD, 지점SM, 관리자1, 관리자2, 사용자, 게스트

    private String blockDetail;
    private String email;
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date blockAt;

    // Organization
    // Login Yn
    // Login Date
    // Logout Date
    // Session / token
    // Permission
    // Access Failure Count
    // Lock Status


    //--------------------------------------------------------------------------------
    @PrePersist
    public void prePersist() {
        this.fullName = this.firstName + " " + this.lastName;
        this.createdAt = new Date();
        this.failCnt = 0;
        this.locked = "N";
    }

    @PreUpdate
    public void preUpdate() {

    }

    @Transient
    private static final int FAIL_MAX = 5;

    public HttpStatus accessFailed() {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
//        httpStatus = HttpStatus.FORBIDDEN;   // 403

        this.failCnt++;
        if (this.failCnt >= FAIL_MAX) {
            this.locked = "Y";
            httpStatus = HttpStatus.LOCKED;
        }

        return httpStatus;
    }

    private void updateAccessTime() {
        this.accessedAt = new Date();
    }

    public void accessSucceeded(boolean timestamp, String session, String token) {
        this.failCnt = 0;
        this.locked = "N";
        if (timestamp) {
            updateAccessTime();
        }
        this.authSession = session;
        this.authToken = token;
    }

    public boolean isLocked() {
        boolean isLocked = false;
        if (this.locked.equals("Y")) {
            isLocked = true;
        }

        return isLocked;
    }

    public void changePassword(String password) {
        this.password = password;
        this.changedPasswordAt = new Date();
    }
    */
}
