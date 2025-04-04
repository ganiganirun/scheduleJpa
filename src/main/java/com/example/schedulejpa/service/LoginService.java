package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.logindto.LoginResponseDto;
import com.example.schedulejpa.entity.Member;
import com.example.schedulejpa.repository.MemberRepository;
import jakarta.validation.constraints.NotBlank;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
  
  private final MemberRepository memberRepository;

  public LoginResponseDto login(String email, String password) {

    Member findMember =
        memberRepository.findIdByEmailAndPasswordOrElseThrow(
        email,
        password
        );

    return new LoginResponseDto(findMember.getId());
  }

  public LoginResponseDto finById(Long id) {

    Member findMember = memberRepository.findByIdOrElseThrow(id);

    return new LoginResponseDto(findMember.getId());
  }
}
