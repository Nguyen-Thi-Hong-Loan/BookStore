package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity {
    @Column
    String content;

    @Column
    double totalMoney;

    @Column
    boolean checked;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "bill_id", cascade = CascadeType.ALL)
    private List<BillDetailEntity> billdetail;

    public BillEntity() {
        super();
    }

   
    public BillEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String content,
			double totalMoney, boolean checked, UserEntity userEntity, List<BillDetailEntity> billdetail) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.content = content;
		this.totalMoney = totalMoney;
		this.checked = checked;
		this.userEntity = userEntity;
		this.billdetail = billdetail;
	}


	public List<BillDetailEntity> getBilldetail() {
		return billdetail;
	}


	public void setBilldetail(List<BillDetailEntity> billdetail) {
		this.billdetail = billdetail;
	}


	public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
