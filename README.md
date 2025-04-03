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
3. lv4 요구사항 정의
   - 키워드
      - HttpServletRequest / HttpServletResponse : 각 HTTP 요청에서 주고받는 값들을 담고 있다.
   - 설명
      - Cookie / Session 을 활용해 로그인 기능을 구현한다.
      - 필터를 활용해 인증 처리를 한다.
      - @Configuration 을 활용해 필터를 등록한다.
   - 조건
      - 이메일과 비밀번호를 활용해 로그인 기능을 구현한다.
      - 회원가입, 로그인 요청은 인증처리에서 제외한다.
   - 예외처리
      - 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 Http Status code 401을 반환한다.