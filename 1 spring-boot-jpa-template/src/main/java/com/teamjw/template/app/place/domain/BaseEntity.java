package com.teamjw.template.app.place.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * 베이스 엔티티 클래스
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
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column(name = "create_user_name", length = 100)
    private String createUserName;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Column(name = "update_user_name", length = 100)
    private String updateUserName;

    @Column(name = "use_yn", length = 1)
    private String useYn = "Y";

    @Column(name = "del_yn", length = 1)
    private String delYn = "N";



    public boolean isNew() {
        return this.id == null;
    }

}
