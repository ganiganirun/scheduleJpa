package com.example.schedulejpa.dto.memberdto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

  private final Long id;

  private final String username;

  private final String email;

  private final LocalDateTime modifiedAt;

  public SignUpResponseDto(Long id, String username, String email, LocalDateTime modifiedAt) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.modifiedAt = modifiedAt;
  }
}
