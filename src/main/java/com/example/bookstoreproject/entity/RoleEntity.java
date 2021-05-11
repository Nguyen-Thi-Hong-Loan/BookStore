package com.example.bookstoreproject.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
    //	@Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @Column
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    public RoleEntity() {
        super();
    }

    public RoleEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, int check, String roleName, List<UserEntity> users) {
        super(id, createDate, createBy, modifyDate, modifyBy);
        this.roleName = roleName;
        this.users = users;
    }

    public RoleEntity(String roleName) {
        super();
        this.roleName = roleName;

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

}
