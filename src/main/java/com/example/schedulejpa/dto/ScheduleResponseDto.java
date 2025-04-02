package com.example.schedulejpa.dto;

import com.example.schedulejpa.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

  private final Long id;

  private final String username;

  private final String title;

  private final String contents;

  private final LocalDateTime modifiedAt;


  // 필드가 final로 선언되어서 생성자가 필요
  public ScheduleResponseDto(Schedule schedule) {
    this.id = schedule.getId();
    this.username = schedule.getUsername();
    this.title = schedule.getTitle();
    this.contents = schedule.getContents();
    this.modifiedAt = schedule.getModifiedAt();
  }
}
