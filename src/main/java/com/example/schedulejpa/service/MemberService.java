package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.memberdto.MemberResponseDto;
import com.example.schedulejpa.dto.memberdto.SignUpResponseDto;
import com.example.schedulejpa.entity.Member;
import com.example.schedulejpa.entity.Schedule;
import com.example.schedulejpa.repository.MemberRepository;
import com.example.schedulejpa.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final ScheduleRepository scheduleRepository;

  public SignUpResponseDto signUp(String username, String email, String password) {

    Member member = new Member(username, email, password);

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

  public void updatePassword(Long id, String oldPassword, String newPassword) {
    Member findMember = memberRepository.findByIdOrElseThrow(id);

    if(!findMember.getPassword().equals(oldPassword)){
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
    }

    findMember.updatePassword(newPassword);


  }
}
