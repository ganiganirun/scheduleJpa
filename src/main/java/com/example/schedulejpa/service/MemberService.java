package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.memberdto.MemberResponseDto;
import com.example.schedulejpa.dto.memberdto.SignUpResponseDto;
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
public class MemberService {

  private final MemberRepository memberRepository;
  private final ScheduleRepository scheduleRepository;

  public SignUpResponseDto signUp(String username, String email) {

    Member member = new Member(username, email);

    Member savedMember = memberRepository.save(member);

    return new SignUpResponseDto(
        savedMember.getId(),
        savedMember.getUsername(),
        savedMember.getEmail(),
        savedMember.getModifiedAt()
    );

  }

  public MemberResponseDto findById(Long id) {

    Member findMember = memberRepository.findByIdOrElseThrow(id);

    return new MemberResponseDto(
        findMember.getUsername(),
        findMember.getEmail(),
        findMember.getModifiedAt()
    );
  }

  @Transactional
  public void deleteMember(Long id) {
    Member findMember = memberRepository.findByIdOrElseThrow(id);
    List<Schedule> findScheduleList = scheduleRepository.findAllByMemberId(findMember.getId());

    scheduleRepository.deleteAll(findScheduleList);
    memberRepository.delete(findMember);
  }
}
