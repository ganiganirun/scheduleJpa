package com.example.schedulejpa.repository;

import com.example.schedulejpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface MemberRepository extends JpaRepository<Member, Long> {

  default Member findByIdOrElseThrow(Long id){
    return findById(id)
        .orElseThrow(()->
            new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Does not exit id = "+id
            )
        );
  }
}
