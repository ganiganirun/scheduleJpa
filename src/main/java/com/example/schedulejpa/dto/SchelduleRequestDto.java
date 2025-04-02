package com.example.schedulejpa.dto;

import com.example.schedulejpa.entity.Schedule;
import lombok.Getter;

@Getter
public class SchelduleRequestDto {

  private final String username;

  private final String title;

  private final String contents;


  public SchelduleRequestDto(String username, String title, String contents) {
    this.username = username;
    this.title = title;
    this.contents = contents;
  }
}
