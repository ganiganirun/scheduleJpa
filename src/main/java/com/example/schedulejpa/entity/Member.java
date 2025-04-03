package com.example.schedulejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 동명이인 가능
  @Column(nullable = false)
  private String username;

  // 근데 같은 이메일은 불가능
  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  public Member(){}

  public Member(String username, String email, String password){
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public void updatePassword(String password){
    this.password =password;
  }

}
