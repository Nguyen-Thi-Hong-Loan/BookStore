package com.example.bookstoreproject.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreatedDate
    private Date createDate;
    @Column
    @CreatedBy
    private String createBy;
    @Column
    @LastModifiedDate
    private Date modifyDate;
    @Column
    @LastModifiedBy
    private String modifyBy;

    @Column
    private int check;

    public int isCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public BaseEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy,
                      int check) {
        this.id = id;
        this.createDate = createDate;
        this.createBy = createBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.check = check;
    }

    public BaseEntity() {
		super();
	}

    public BaseEntity(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }
}
