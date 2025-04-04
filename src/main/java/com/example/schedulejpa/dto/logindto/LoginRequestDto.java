package com.example.schedulejpa.dto.logindto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

  @NotBlank
  private final String email;

  @NonNull
  private final String password;

}
