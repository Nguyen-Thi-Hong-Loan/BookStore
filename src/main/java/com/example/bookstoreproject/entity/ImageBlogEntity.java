package com.example.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imageblog")
public class ImageBlogEntity extends BaseEntity {

    @Column
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    private BlogEntity blog_id;

	public ImageBlogEntity() {
		super();
	}

	public ImageBlogEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, int check, String link, BlogEntity blog_id) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.link = link;
		this.blog_id = blog_id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public BlogEntity getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(BlogEntity blog_id) {
		this.blog_id = blog_id;
	}

}
