package com.example.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity {
	@Column
	String content;

	@Column
	double totalmoney;


	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private BookEntity bookEntity;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "billDetail_id")
    private BillDetailEntity billDetail;
	
	public BillEntity() {
		super();
	}


	public BillEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String content,
		 double totalmoney, UserEntity userEntity, BookEntity bookEntity) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.content = content;
		this.totalmoney = totalmoney;
		this.userEntity = userEntity;
		this.bookEntity = bookEntity;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}



	public double getTotalmoney() {
		return totalmoney;
	}


	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public BookEntity getBookEntity() {
		return bookEntity;
	}


	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}


	

}
