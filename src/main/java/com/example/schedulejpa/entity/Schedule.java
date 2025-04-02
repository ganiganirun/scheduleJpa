package com.example.schedulejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "schedule")
public class Schedule extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "Longtext")
  private String contents;

  public Schedule(){}

  public Schedule(String username, String title, String contents){
    this.username = username;
    this.title = title;
    this.contents = contents;
  }



}
