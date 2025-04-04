package com.example.schedulejpa.controller;


import com.example.schedulejpa.common.Const;
import com.example.schedulejpa.dto.logindto.LoginRequestDto;
import com.example.schedulejpa.dto.logindto.LoginResponseDto;
import com.example.schedulejpa.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(
      @Valid @RequestBody LoginRequestDto requestDto,
      HttpServletRequest request
  ){
    LoginResponseDto responseDto = loginService.login(requestDto.getEmail(), requestDto.getPassword());

    Long id = responseDto.getId();

    LoginResponseDto loginUser = loginService.finById(id);

    HttpSession session = request.getSession();

    session.setAttribute(Const.LOGIN_USER, loginUser);

    return new ResponseEntity<>(loginUser, HttpStatus.OK);

  }

  @PostMapping("/logout")
  public ResponseEntity<Void> logout(HttpServletRequest request){
    HttpSession session = request.getSession(false);
    if(session != null){
      session.invalidate();
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
