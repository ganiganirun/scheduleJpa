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
3. API
![스크린샷 2025-04-02 오후 2 20 18](https://github.com/user-attachments/assets/92590ecd-8ff6-48f1-88a4-a379c0d33ba0)

![스크린샷 2025-04-02 오후 2 19 46](https://github.com/user-attachments/assets/4a354106-de73-4534-a5f5-7c7c81721c18)


   
4. ERD

![스크린샷 2025-04-02 오후 2 20 48](https://github.com/user-attachments/assets/7f4c1513-bf1f-480d-b298-c644a0a35432)
