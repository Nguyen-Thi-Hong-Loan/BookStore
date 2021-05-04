package com.example.bookstoreproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column
	String email;
	@Column
	String password;
	@Column
	int phone;
	@Column
	String address;
	

	@Column
	String resetPasswordToken;


	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<>();

	
	@OneToMany(mappedBy = "userEntity")
	private List<BillEntity> bill;
	
	@OneToMany(mappedBy = "userEntity")
	private List<FeedbackEntity> feedback;

	
	public UserEntity() {
		super();
	}


	public UserEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String email,
			String password, int phone, String address, String resetPasswordToken, List<RoleEntity> roles,
			List<BillEntity> bill, List<FeedbackEntity> feedback) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.resetPasswordToken = resetPasswordToken;
		this.roles = roles;
		this.bill = bill;
		this.feedback = feedback;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getResetPasswordToken() {
		return resetPasswordToken;
	}


	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}


	public List<RoleEntity> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}


	public List<BillEntity> getBill() {
		return bill;
	}


	public void setBill(List<BillEntity> bill) {
		this.bill = bill;
	}


	public List<FeedbackEntity> getFeedback() {
		return feedback;
	}


	public void setFeedback(List<FeedbackEntity> feedback) {
		this.feedback = feedback;
	}

	
	
}
