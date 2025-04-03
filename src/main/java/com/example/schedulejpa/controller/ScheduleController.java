package com.example.schedulejpa.controller;

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

  // 일정 전체 조회
  @GetMapping
  public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){

    List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

    return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);

  }

  // 일정 선택 조회
  @GetMapping("/{id}")
  public ResponseEntity<ScheduleResponseDto> findByIdSchedule(@PathVariable Long id){

    ScheduleResponseDto findSchedule = scheduleService.findById(id);

    return new ResponseEntity<>(findSchedule,HttpStatus.OK);
  }

  // 일정 선택 수정
  @PatchMapping("/{id}")
  public ResponseEntity<ScheduleResponseDto> updateSchedule(
      @PathVariable Long id,
      @RequestBody SchelduleRequestDto requestDto
  ){

    ScheduleResponseDto scheduleResponseDto =
        scheduleService.updateSchedule(
            id,
            requestDto.getUsername(),
            requestDto.getTitle(),
            requestDto.getContents());

    return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){

    scheduleService.deleteSchedule(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
