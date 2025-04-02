package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.dto.SchelduleRequestDto;
import com.example.schedulejpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor // final or @NonNull 이 붙은 필드만 매개변수로 받는 생성자 자동 생성 어노테이션
public class ScheduleController {

  private final ScheduleService scheduleService;

  // 일정 생성
  @PostMapping
  public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody SchelduleRequestDto requestDto){

    ScheduleResponseDto scheduleResponseDto =
        scheduleService.saveSchedule(
            requestDto.getUsername(),
            requestDto.getTitle(),
            requestDto.getContents()
        );

    return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
  }

}
