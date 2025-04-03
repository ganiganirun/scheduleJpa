package com.example.schedulejpa.controller;


import com.example.schedulejpa.dto.memberdto.SignUpRequestDto;
import com.example.schedulejpa.dto.memberdto.SignUpResponseDto;
import com.example.schedulejpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/signup")
  public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){

    SignUpResponseDto signUpResponseDto =
        memberService.signUp(
            requestDto.getUsername(),
            requestDto.getEmail()
        );

    return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
  }

}
