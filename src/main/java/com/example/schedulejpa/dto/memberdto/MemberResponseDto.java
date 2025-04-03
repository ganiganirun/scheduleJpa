package com.example.schedulejpa.dto.memberdto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class MemberResponseDto {

  private final String username;

  private final String email;

  private final LocalDateTime modifiedAt;

  public MemberResponseDto(String username, String email, LocalDateTime modifiedAt) {
    this.username = username;
    this.email = email;
    this.modifiedAt = modifiedAt;
  }
}
