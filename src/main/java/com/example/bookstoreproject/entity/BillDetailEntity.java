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

}
