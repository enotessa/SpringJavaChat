package com.enotessa.SpringJavaChat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @Column(name = "user_name", length = 20, nullable = false)
    private String userName;
    @Column(name = "password", length = 40, nullable = false)
    private String password;
    @Column(name = "role", length = 10)
    private String role;

    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {return role;}

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return this.getUserName()+' '+this.getRole();
    }
}
