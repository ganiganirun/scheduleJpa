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
3. lv2 요구사항 정의
   - 유저를 생성, 조회, 수정, 삭제할 수 있습니다.
   - 유저는 아래 필드를 가진다.
      - 유저명, 이메일, 작성일, 수정일 필드
      - 작성일, 수정일 필드는 JPA Auditing을 활용한다. 
   - 연관관계를 구현한다.
      - 일정은 이제 작성 유저명 필드 대신 유저 고유 식별자 필드를 가진다.
    
4. 유저 등록
   
   ![스크린샷 2025-04-03 오후 5 06 31](https://github.com/user-attachments/assets/4ea36d5c-fdcb-4864-9920-93542d6d0bce)
   
   ![스크린샷 2025-04-03 오후 5 07 36](https://github.com/user-attachments/assets/1fe02735-f7ef-4b54-a73b-0c520c2d40d5)
   
   ![스크린샷 2025-04-03 오후 5 07 59](https://github.com/user-attachments/assets/f8720b3f-415f-47e8-8392-8b66e64e66e8)

5. 유저 조회

   ![스크린샷 2025-04-03 오후 5 08 53](https://github.com/user-attachments/assets/d7bdb49d-69ee-4cb4-a715-aa4a3dff18a1)

   ![스크린샷 2025-04-03 오후 5 08 33](https://github.com/user-attachments/assets/96efeaf9-0733-4978-9ed0-b5b66a813fa5)

6. 유저 삭제

    ![스크린샷 2025-04-03 오후 5 53 13](https://github.com/user-attachments/assets/ba2d55c1-59e9-41a2-805a-1c6b954ee5a4)

    ![스크린샷 2025-04-03 오후 5 53 39](https://github.com/user-attachments/assets/d6fc49b9-a0b6-41e1-9343-93396f75e266)

    ![스크린샷 2025-04-03 오후 5 53 55](https://github.com/user-attachments/assets/7faf07fd-9dc7-406c-bf4f-7e79fbb35d9d)

7. 일정 등록
    
    ![스크린샷 2025-04-03 오후 5 10 12](https://github.com/user-attachments/assets/5840be1f-2744-47fb-a606-ababa812fb09)
    
    ![스크린샷 2025-04-03 오후 5 10 30](https://github.com/user-attachments/assets/90d1c58b-4278-40a0-92a7-219a7f745ba9)

    ![스크린샷 2025-04-03 오후 5 12 04](https://github.com/user-attachments/assets/048ac034-3e51-4a11-a25f-d14a7ca2dccb)
    
8. 일정 전체 조회
    
    ![스크린샷 2025-04-03 오후 5 12 39](https://github.com/user-attachments/assets/7122c1e1-b160-4598-9e62-591b4097d64f)

    ![스크린샷 2025-04-03 오후 5 13 58](https://github.com/user-attachments/assets/b9fd2aa7-0c2a-45d8-a848-67045bb21fd6)
    
9. 일정 단건 조회
    
    ![스크린샷 2025-04-03 오후 5 14 38](https://github.com/user-attachments/assets/f17a369c-fa1d-4b0d-bbaf-8359c0c07402)

10. 일정 수정
    
    ![스크린샷 2025-04-03 오후 5 17 14](https://github.com/user-attachments/assets/3d54c347-42e0-4834-8c05-66209dbc80df)

    ![스크린샷 2025-04-03 오후 5 17 54](https://github.com/user-attachments/assets/b6c4b604-7173-4626-842e-da004cfda42a)

11. 일정 삭제

    ![스크린샷 2025-04-03 오후 5 18 36](https://github.com/user-attachments/assets/d03ad668-275a-46d7-9932-7200db62aaa1)

    ![스크린샷 2025-04-03 오후 5 18 50](https://github.com/user-attachments/assets/f745a2b9-2c48-496f-adea-7f2cb22ea31e)
