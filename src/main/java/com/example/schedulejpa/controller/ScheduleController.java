package com.example.schedulejpa.controller;

import com.example.schedulejpa.common.Const;
import com.example.schedulejpa.dto.logindto.LoginResponseDto;
import com.example.schedulejpa.dto.scheduledto.ScheduleResponseDto;
import com.example.schedulejpa.dto.scheduledto.SchelduleRequestDto;
import com.example.schedulejpa.service.ScheduleService;
import java.util.List;
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
@RequestMapping("/schedules")
@RequiredArgsConstructor // final or @NonNull 이 붙은 필드만 매개변수로 받는 생성자 자동 생성 어노테이션
public class ScheduleController {

  private final ScheduleService scheduleService;

  // 일정 생성
  @PostMapping
  public ResponseEntity<ScheduleResponseDto> saveSchedule(
      @SessionAttribute(name = Const.LOGIN_USER, required = false) LoginResponseDto loginUser,
      @RequestBody SchelduleRequestDto requestDto
  ){
    ScheduleResponseDto scheduleResponseDto =
        scheduleService.saveSchedule(
            loginUser.getId(),
            requestDto.getTitle(),
            requestDto.getContents()
        );

    return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
  }

  // 일정 전체 조회
  @GetMapping
  public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(@SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser){

    List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll(loginUser.getId());

    return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);

  }

  // 일정 선택 조회
  @GetMapping("/{scheduleId}")
  public ResponseEntity<ScheduleResponseDto> findByIdSchedule(
      @SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser,
      @PathVariable Long scheduleId
  ){

    ScheduleResponseDto findSchedule = scheduleService.findById(loginUser.getId(), scheduleId);

    return new ResponseEntity<>(findSchedule,HttpStatus.OK);
  }

  // 일정 선택 수정
  @PatchMapping("/{scheduleId}")
  public ResponseEntity<ScheduleResponseDto> updateSchedule(
      @SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser,
      @PathVariable Long scheduleId,
      @RequestBody SchelduleRequestDto requestDto
  ){

    ScheduleResponseDto scheduleResponseDto =
        scheduleService.updateSchedule(
            loginUser.getId(),
            scheduleId,
            requestDto.getTitle(),
            requestDto.getContents());

    return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
  }

  @DeleteMapping("/{scheduleId}")
  public ResponseEntity<Void> deleteSchedule(
      @SessionAttribute(name = Const.LOGIN_USER, required = false)LoginResponseDto loginUser,
      @PathVariable Long scheduleId
  ){

    scheduleService.deleteSchedule(loginUser.getId(),scheduleId);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
