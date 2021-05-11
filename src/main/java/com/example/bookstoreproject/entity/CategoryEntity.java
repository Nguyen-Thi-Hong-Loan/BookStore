package com.example.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Column
    private String category_name;

    @ManyToOne(cascade = CascadeType.ALL)
    private BookEntity book_id;

    public CategoryEntity() {
    	super();
    }

	public CategoryEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, int check, String category_name, BookEntity book_id) {
		super(id, createDate, createBy, modifyDate, modifyBy, check);
		this.category_name = category_name;
		this.book_id = book_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public BookEntity getBook_id() {
		return book_id;
	}

	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}
    
}