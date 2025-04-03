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
3. lv3 요구사항 정의
   - 유저에 비밀번호 필드를 추가합니다.
    - 비밀번호 암호화는 도전 기능에서 수행합니다.
4. 유저 등록

![스크린샷 2025-04-03 오후 7 33 16](https://github.com/user-attachments/assets/cbf46431-57a1-4b6e-8e9f-7dca8c13d0d0)
![스크린샷 2025-04-03 오후 7 34 00](https://github.com/user-attachments/assets/1399537a-ca7d-4f0a-8fbb-4d959387ed30)

5. 비밀번호 수정

![스크린샷 2025-04-03 오후 7 34 32](https://github.com/user-attachments/assets/4d349124-23db-4e3a-a371-0250981d164f)
![스크린샷 2025-04-03 오후 7 34 58](https://github.com/user-attachments/assets/eab9954e-7b3b-4574-a573-c64b55aa56d7)
