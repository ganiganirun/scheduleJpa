package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.scheduledto.ScheduleResponseDto;
import com.example.schedulejpa.entity.Member;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.MemberRepository;
import com.example.schedulejpa.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final MemberRepository memberRepository;

  private final ScheduleRepository scheduleRepository;


  public ScheduleResponseDto saveSchedule(Long memberId, String title, String contents) {

    Member findMember = memberRepository.findByIdOrElseThrow(memberId);
    Schedule schedule = new Schedule(title, contents);
    schedule.setMember(findMember);
    Schedule savedSchedule = scheduleRepository.save(schedule);

//    // 트랜젝션이 끝나면 jpa의 변경 감지 기능을 사용할 수 없음...
//    Schedule savedSchedule = scheduleRepository.save(new Schedule(username, title, contents));

    return new ScheduleResponseDto(
        savedSchedule.getId(),
        savedSchedule.getTitle(),
        savedSchedule.getContents(),
        savedSchedule.getModifiedAt());
  }

  public List<ScheduleResponseDto> findAll(Long memberId) {
    scheduleRepository.findAll();

    return scheduleRepository.findAllByMemberId(memberId)
        .stream()
        .map(ScheduleResponseDto::toDto)
        .toList();
  }

  public ScheduleResponseDto findById(Long memberId, Long scheduleId) {

    Schedule findSchedule = scheduleRepository.findByMemberIdAndIdOrElseThrow(memberId,scheduleId);

    return new ScheduleResponseDto(
        findSchedule.getId(),
        findSchedule.getTitle(),
        findSchedule.getContents(),
        findSchedule.getModifiedAt()
    );
  }

  @Transactional
  public ScheduleResponseDto updateSchedule(Long memberId ,Long scheduleId, String title, String contents) {

    Schedule findSchedule = scheduleRepository.findByMemberIdAndIdOrElseThrow(memberId,scheduleId);

    findSchedule.updateSchedule(title,contents);

    return new ScheduleResponseDto(
        findSchedule.getId(),
        findSchedule.getTitle(),
        findSchedule.getContents(),
        findSchedule.getModifiedAt()
    );
  }

  public void deleteSchedule(Long memberId, Long scheduleId) {

    Schedule findSchedule = scheduleRepository.findByMemberIdAndIdOrElseThrow(memberId,scheduleId);

    scheduleRepository.delete(findSchedule);
  }
}
