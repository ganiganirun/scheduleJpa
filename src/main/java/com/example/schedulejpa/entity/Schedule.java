package com.example.schedulejpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //
  private Long id;

//  @Column(nullable = false)
//  private String username;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "Longtext")
  private String contents;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  public Schedule(){}

  public Schedule(String title, String contents){
    this.title = title;
    this.contents = contents;
  }

  public void updateSchedule(String title, String contents){
    this.title = title;
    this.contents = contents;
  }


  // 무슨 멤버를 넣어줄지 해주는 아이
  // 누가 실제로 쓴건지 데이터에 대한 내용
  // 값을 넣어주메
  public void setMember(Member member){
    this.member = member;
  }

}
