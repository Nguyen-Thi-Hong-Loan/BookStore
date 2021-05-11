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
	double totalMoney;


	@ManyToOne(cascade = CascadeType.ALL)
	private UserEntity userEntity;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "billDetail_id")
    private BillDetailEntity billDetail;
	
	public BillEntity() {
		super();
	}


	public BillEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, int check, String content, double totalMoney, UserEntity userEntity, BillDetailEntity billDetail) {
		super(id, createDate, createBy, modifyDate, modifyBy, check);
		this.content = content;
		this.totalMoney = totalMoney;
		this.userEntity = userEntity;
		this.billDetail = billDetail;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}



	public double getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	

}
