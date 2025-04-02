CREATE TABLE member(
    id  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고유 식별자',
    username VARCHAR(100) NOT NULL COMMENT '유저 이름',
    email VARCHAR(255) NOT NULL UNIQUE COMMENT '유저 이메일',
    created_at DATETIME COMMENT '생성일',
    modified_at DATETIME COMMENT '수정일'
);

ALTER TABLE member ADD COLUMN 'password' VARCHAR(100)

CREATE TABLE schedule(
    id  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '고유 식별자',
    member_id BIGINT NOT NULL COMMENT '와래키',
    username VARCHAR(100) NOT NULL COMMENT '작성 유저명',
    title VARCHAR(255) NOT NULL COMMENT '할일 제목',
    contents LONGTEXT NOT NULL COMMENT '할일 내용',
    created_at DATETIME COMMENT '생성일',
    modified_at DATETIME COMMENT '수정일'.
    FOREIGN KEY (member_id) REFERENCES member(id)
);