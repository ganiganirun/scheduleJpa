package com.example.schedulejpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// baseEntity는 클래스가 아닌 추상클래스로 해주는 게 좋음
// 다른 곳에서 인스턴스화 시켜서 사용 못함
// 생성일 수정일 자동화
@Getter
@MappedSuperclass // JPA에서 공통 엔티티의 매핑 정보 정의 시 사용하는 어노테이션
@EntityListeners(AuditingEntityListener.class) // JPA Auditing(감사 기능)을 활성화 시키는 어노테이션 -> 엔티티 생성 수정 시간 자동 기록 가능
public abstract class BaseEntity {

  @CreatedDate // 엔티티가 처음 생성될 때 자동으로 날짜 저장 어노테이션
  @Column(updatable = false) // 생성일은 수정되면 안됨
  private LocalDateTime createdAt;

  @LastModifiedDate // 엔티티가 마지막으로 수정된 날짜 자동 업데이트 어노테이션
  private LocalDateTime modifiedAt;

}
