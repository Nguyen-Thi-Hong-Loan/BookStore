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
	
	@OneToMany(mappedBy = "userEntity")
	private List<BookEntity> book ;

	
	public UserEntity() {
		super();
	}

	
	
}
