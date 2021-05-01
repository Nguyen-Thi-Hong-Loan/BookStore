package com.exam.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity {
	@Column
	String content;
	@Column
	String time;

	@Column
	double totalmoney;


	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	private BookEntity bookEntity;


	public BillEntity() {
		super();
	}


	public BillEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String content,
			String time, double totalmoney, UserEntity userEntity, BookEntity bookEntity) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.content = content;
		this.time = time;
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


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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
