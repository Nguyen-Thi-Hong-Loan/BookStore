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
	
	@OneToOne(mappedBy = "billDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private BillEntity bill;

	@Column
	private Integer quality;

	@Column
	private Double price;

	public BillDetailEntity() {
		super();
	}

	public BookEntity getBook_id() {
		return book_id;
	}

	public void setBook_id(BookEntity book_id) {
		this.book_id = book_id;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
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
