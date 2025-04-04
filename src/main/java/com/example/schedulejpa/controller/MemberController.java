package com.example.schedulejpa.controller;


import com.example.schedulejpa.common.Const;
import com.example.schedulejpa.dto.logindto.LoginResponseDto;
import com.example.schedulejpa.dto.memberdto.MemberResponseDto;
import com.example.schedulejpa.dto.memberdto.SignUpRequestDto;
import com.example.schedulejpa.dto.memberdto.SignUpResponseDto;
import com.example.schedulejpa.dto.memberdto.UpdatePasswordRequestDto;
import com.example.schedulejpa.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.SessionAttribute;

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

  @GetMapping
  public ResponseEntity<MemberResponseDto> findById(
      @SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser
      ){

    MemberResponseDto memberResponseDto = memberService.findById(loginUser.getId());

    return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);

  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updatePassword(
      @SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser,
      @RequestBody UpdatePasswordRequestDto passwordRequestDto
  ){

    memberService.updatePassword(loginUser.getId(), passwordRequestDto.getOldPassword(), passwordRequestDto.getNewPassword());

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteMember(@SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser){
    memberService.deleteMember(loginUser.getId());

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
