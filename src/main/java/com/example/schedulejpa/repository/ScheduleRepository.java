package com.example.schedulejpa.repository;

import com.example.schedulejpa.dto.scheduledto.ScheduleResponseDto;
import com.example.schedulejpa.entity.Schedule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  // Member_id에 맞는 데이터를 모두 가져와 리스트 형태로 반환하는 쿼리 메소드
  List<Schedule> findAllByMemberId(Long memberId);

//  Optional<Member> findMemberByUsername(String username);
//
//  default Member findMemberByUsernameOrElseUsername(String username){
//    return findMemberByUsername(username)
//        .orElseThrow(()->
//            new ResponseStatusException(
//                HttpStatus.NOT_FOUND,
//                "Does not exit username = " + username
//            )
//        );
//  }


  // Member_id와 id와 일치할시 optional로 감싼 schedule 객체를 반환
  Optional<Schedule> findByMemberIdAndId(Long memberId, Long scheduleId);

  // 만약 optional로 감싼 schedule 객체가 null일 경우
  default Schedule findByMemberIdAndIdOrElseThrow(Long memberId, Long scheduleId){
    return findByMemberIdAndId(memberId,scheduleId)
        .orElseThrow(()->
            new ResponseStatusException(
                HttpStatus.NOT_FOUND ,
                "Does not exist id = " + scheduleId
            )
        );
  }
}
