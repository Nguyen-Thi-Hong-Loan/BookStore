package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "billDetail")
public class BillDetailEntity extends BaseEntity {

	@ManyToOne(cascade = CascadeType.ALL)
	private BookEntity book_id;
	
	  @ManyToOne(cascade = CascadeType.ALL)
	    private BillEntity bill_id;

	@Column
	private Integer quality;

	@Column
	private Double price;

	
	public BillDetailEntity() {
		super();
	}

	

	public BillDetailEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy,
			BookEntity book_id, BillEntity bill_id, Integer quality, Double price) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.book_id = book_id;
		this.bill_id = bill_id;
		this.quality = quality;
		this.price = price;
	}



	public BookEntity getBook_id() {
		return book_id;
	}

	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}

	
	public BillEntity getBill_id() {
		return bill_id;
	}



	public void setBill_id(BillEntity bill_id) {
		this.bill_id = bill_id;
	}



	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
