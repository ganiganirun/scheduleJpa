package com.example.schedulejpa.dto.memberdto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

  private final String username;

  private final String email;

  private final String password;


  public SignUpRequestDto(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
