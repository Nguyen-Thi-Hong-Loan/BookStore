package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity extends BaseEntity {

    @Column
    String title;

    @Column
    String description;
    

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;


    @OneToMany(mappedBy = "blog_id", cascade = CascadeType.ALL)
    private List<ImageBlogEntity> imageblog;


	public BlogEntity() {
		super();
	}


	public BlogEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String title,
			String description, UserEntity userEntity, List<ImageBlogEntity> imageblog) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.title = title;
		this.description = description;
		this.userEntity = userEntity;
		this.imageblog = imageblog;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public List<ImageBlogEntity> getImageblog() {
		return imageblog;
	}


	public void setImageblog(List<ImageBlogEntity> imageblog) {
		this.imageblog = imageblog;
	}
    
    
}
