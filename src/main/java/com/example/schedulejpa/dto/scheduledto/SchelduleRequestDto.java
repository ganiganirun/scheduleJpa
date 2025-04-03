package com.example.schedulejpa.dto.scheduledto;

import lombok.Getter;

@Getter
public class SchelduleRequestDto {

//  private final String username;

//  private final Long userId;

  private final String title;

  private final String contents;

  // 필드가 final로 선언되어서 생성자가 필요
  public SchelduleRequestDto(String title, String contents) {
//    this.userId = userId;
    this.title = title;
    this.contents = contents;
  }
}
