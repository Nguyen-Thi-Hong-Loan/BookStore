package com.example.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedbackEntity extends BaseEntity{

	@Column
	String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private BookEntity book_id;


	public FeedbackEntity() {
		super();
	}


	public FeedbackEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, int check, String content, UserEntity userEntity, BookEntity book_id) {
		super(id, createDate, createBy, modifyDate, modifyBy, check);
		this.content = content;
		this.userEntity = userEntity;
		this.book_id = book_id;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public BookEntity getBook_id() {
		return book_id;
	}


	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}



}
