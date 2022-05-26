package com.mysquare.restoms.model;

import javax.persistence.*;

@Entity
@Table(name="login_details",schema="restro")
public class LoginDetails {
    private int id;
    private String uname;
    private String password;
    private String role;

    //cstr with id
    public LoginDetails(int id, String uname, String password,String role) {
        super();
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.role=role;
    }

    //cstr without id
    public LoginDetails(String uname, String password,String role) {
        super();
        this.uname = uname;
        this.password = password;
        this.role=role;
    }

    //default cstr
    public LoginDetails() {
        super();
    }

    //id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //getter for uname
    @Column(length=20)
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    // getter password
    @Column(length=20,nullable=false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for role
    @Column(length=20)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "LoginDetails [id=" + id + ", uname=" + uname + ", password=" + password + ", role=" + role + "]";
    }
}
