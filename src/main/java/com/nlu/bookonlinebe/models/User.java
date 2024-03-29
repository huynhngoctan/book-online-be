package com.nlu.bookonlinebe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private Date birthday;
    private String phone;
    private String address;
    private String role;
    private String status;
    private String avatar;
    private String recoveryCode;

    public User( String username, String password, String email, String fullname, Date birthday, String phone, String address, String role, String status, String avatar) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.status = status;
        this.avatar = avatar;
    }

    public User(String fullname, String email, String password){
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }
}
