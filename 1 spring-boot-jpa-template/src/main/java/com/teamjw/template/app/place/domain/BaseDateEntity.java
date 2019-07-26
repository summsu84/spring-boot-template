package com.teamjw.template.app.place.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 베이스 s 엔티티 클래스
 * DESC : ID, 생성일자, 생성자, 수정일자, 수정자 정보
 * DATE : 2019.01.16
 *
 * 아이디(PK), 생성일자, 생성자, 수정일자, 수정자
 *
 * @author teamjw - JJW
 */
@MappedSuperclass
@Getter
@Setter
public class BaseDateEntity implements Serializable {


    @Column(name= "created_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column(name = "create_user_name")
    private String createUserName;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Column(name = "update_user_name")
    private String updateUserName;

    @Column(name = "use_yn")
    private String useYn = "Y";

    @Column(name = "del_yn")
    private String delYn = "N";

}
