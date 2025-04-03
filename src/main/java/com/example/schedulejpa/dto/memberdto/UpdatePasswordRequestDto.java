package com.example.schedulejpa.dto.memberdto;

import com.example.schedulejpa.entity.Schedule;
import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

  private final String oldPassword;

  private final String newPassword;

  public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
    this.oldPassword = oldPassword;
    this.newPassword = newPassword;
  }
}
