# scheduleJpa

1. 프로젝트 소개
    - 해당 프로젝트는 일정관리어플 구현을 통해 spring의 핵심 컨셉과 validation에 대해 학습하는 프로젝트이다.
    - 인증과 인가를 통해 어플리케이션의 보안과 접근을 제어하는 방법을 다룬다. Servlet Filter와 Cookie/ session을 사용하여 인증과 인가를 구현한다.
    - JPA를 본격적으로 다루며 연관관계 설정, CRUD 등을 배우며 JPA의 주요 개념을 이해하고 실제 어플리케이션에 적용해보도록 한다.
2. 요구사항 정의
    - 공통 요구사항
        - 모든 테이블은 고유 식별자(ID)를 가진다.
        - 3 Layer Architecture에 따라 각 Layer의 목적에 맞게 개발한다.
        - CRUD 필수 기능은 모두 데이터 베이스 연결 및 JPA를 사용하여 개발한다.
        - 인증/인가 절차는 Cookie/Session을 활용하여 개발한다.
        - JPA 연관관계는 단방향으로 하고 필요시에만 양방향을 적용하도록 한다.
3. lv1 요구사항 정의
   - 일정을 생성, 조회, 수정, 삭제 가능하다.
   - 일정은 아래 필드를 가진다.
      - 작성 유저명, 할일 제목, 할일 내용, 작성일, 수정일 필드
      - 작성일, 수정일 필드는 JPA Auditing을 활용한다.
4. 동작
   - 일정 등록
![스크린샷 2025-04-02 오후 7 45 32](https://github.com/user-attachments/assets/47fd0074-a036-40c6-88ac-a4e1cd3c0111)
![스크린샷 2025-04-02 오후 7 45 50](https://github.com/user-attachments/assets/aa6f0c57-97bb-4aea-84ac-d530d26b6c8f)

   - 전체 일정 조회
![스크린샷 2025-04-02 오후 7 46 11](https://github.com/user-attachments/assets/a4d6b7a4-1417-420f-82de-07f88e018c4a)
     
   - 단건 일정 조회
![스크린샷 2025-04-02 오후 7 46 27](https://github.com/user-attachments/assets/62675ad1-bac1-4896-8213-fdad07371a57)

   - 일정 수정
![스크린샷 2025-04-02 오후 7 46 41](https://github.com/user-attachments/assets/583ccb29-c81e-4638-8eb1-4970eb2e0015)
![스크린샷 2025-04-02 오후 7 46 54](https://github.com/user-attachments/assets/ca8a372e-62f1-4bb6-93cc-ce93c00ba36b)
     
   - 일정 삭제
![스크린샷 2025-04-02 오후 7 47 38](https://github.com/user-attachments/assets/4cc90ea9-be60-4db5-be20-608a07b4ab31)
![스크린샷 2025-04-02 오후 7 47 50](https://github.com/user-attachments/assets/920f5b27-6a30-403a-b13e-4f007acfb07e)
