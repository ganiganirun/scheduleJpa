package com.example.schedulejpa.repository;

import com.example.schedulejpa.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface MemberRepository extends JpaRepository<Member, Long> {

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


  default Member findByIdOrElseThrow(Long id){
    return findById(id)
        .orElseThrow(()->
            new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Does not exit id = "+id
            )
        );
  }

  Optional<Member> findIdByEmailAndPassword(String email, String password);

  default Member findIdByEmailAndPasswordOrElseThrow(String email, String password){
    return findIdByEmailAndPassword(email,password)
        .orElseThrow(()->
            new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "일치하는 아이디와 비밀번호가 존재하지 않습니다. 다시 확인해주세요."
            )
        );
  }
}
