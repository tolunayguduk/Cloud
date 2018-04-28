package com.tolunayguduk.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private Long userID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "sign_up_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sign_up_date;
    @Column(name = "confirmation", nullable = true)
    private Boolean confirmation;
    @Column(name = "image", nullable = true)
    private String image;




    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public Date getSign_up_date() {
        return sign_up_date;
    }
    public void setSign_up_date(Date sign_up_date) {
        this.sign_up_date = sign_up_date;
    }
    public Boolean getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
