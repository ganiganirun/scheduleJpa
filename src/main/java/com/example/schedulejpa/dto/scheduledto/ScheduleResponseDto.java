package com.example.schedulejpa.dto.scheduledto;

import com.example.schedulejpa.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

  private final Long id;

  private final String title;

  private final String contents;

  private final LocalDateTime modifiedAt;


  // 필드가 final로 선언되어서 생성자가 필요
  public ScheduleResponseDto(Long id, String title, String contents, LocalDateTime modifiedAt) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.modifiedAt = modifiedAt;
  }

  public static ScheduleResponseDto toDto(Schedule schedule){
    return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getModifiedAt());
  }
}
