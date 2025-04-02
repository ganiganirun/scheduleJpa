package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.ScheduleResponseDto;
import com.example.schedulejpa.dto.SchelduleRequestDto;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;


  public ScheduleResponseDto saveSchedule(String username, String title, String contents) {

    Schedule schedule = new Schedule(username, title, contents);
    Schedule savedSchedule = scheduleRepository.save(schedule);

//    // 트랜젝션이 끝나면 jpa의 변경 감지 기능을 사용할 수 없음...
//    Schedule savedSchedule = scheduleRepository.save(new Schedule(username, title, contents));

    return new ScheduleResponseDto(savedSchedule);
  }
}
