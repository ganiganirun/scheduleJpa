package com.example.schedulejpa.controller;


import com.example.schedulejpa.dto.memberdto.MemberResponseDto;
import com.example.schedulejpa.dto.memberdto.SignUpRequestDto;
import com.example.schedulejpa.dto.memberdto.SignUpResponseDto;
import com.example.schedulejpa.dto.memberdto.UpdatePasswordRequestDto;
import com.example.schedulejpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            requestDto.getEmail(),
            requestDto.getPassword()
        );

    return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
    MemberResponseDto memberResponseDto = memberService.findById(id);

    return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updatePassword(
      @PathVariable Long id,
      @RequestBody UpdatePasswordRequestDto passwordRequestDto
  ){

    memberService.updatePassword(id, passwordRequestDto.getOldPassword(), passwordRequestDto.getNewPassword());

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long id){
    memberService.deleteMember(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
