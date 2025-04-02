package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class SchelduleRequestDto {

  private final String username;

  private final String title;

  private final String contents;

  // 필드가 final로 선언되어서 생성자가 필요
  public SchelduleRequestDto(String username, String title, String contents) {
    this.username = username;
    this.title = title;
    this.contents = contents;
  }
}
