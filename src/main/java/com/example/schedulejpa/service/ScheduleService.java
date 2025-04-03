package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.scheduledto.ScheduleResponseDto;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;


  public ScheduleResponseDto saveSchedule(String username, String title, String contents) {

    Schedule schedule = new Schedule(username, title, contents);
    Schedule savedSchedule = scheduleRepository.save(schedule);

//    // 트랜젝션이 끝나면 jpa의 변경 감지 기능을 사용할 수 없음...
//    Schedule savedSchedule = scheduleRepository.save(new Schedule(username, title, contents));

    return new ScheduleResponseDto(
        savedSchedule.getId(),
        savedSchedule.getUsername(),
        savedSchedule.getTitle(),
        savedSchedule.getContents(),
        savedSchedule.getModifiedAt());
  }

  public List<ScheduleResponseDto> findAll() {

    return scheduleRepository.findAll()
        .stream()
        .map(ScheduleResponseDto::toDto)
        .toList();
  }

  public ScheduleResponseDto findById(Long id) {

    Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

    return new ScheduleResponseDto(
        findSchedule.getId(),
        findSchedule.getUsername(),
        findSchedule.getTitle(),
        findSchedule.getContents(),
        findSchedule.getModifiedAt()
    );
  }

  @Transactional
  public ScheduleResponseDto updateSchedule(Long id, String username, String title, String contents) {

    Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

    findSchedule.updateSchedule(username,title,contents);

    return new ScheduleResponseDto(
        findSchedule.getId(),
        findSchedule.getUsername(),
        findSchedule.getTitle(),
        findSchedule.getContents(),
        findSchedule.getModifiedAt()
    );
  }

  public void deleteSchedule(Long id) {

    Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

    scheduleRepository.delete(findSchedule);
  }
}
