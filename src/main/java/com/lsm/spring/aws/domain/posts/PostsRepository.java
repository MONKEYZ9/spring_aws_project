package com.lsm.spring.aws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//이게 보통은 Dao라고 불리는 DB Layer접근자이다
//JPA에선 Repository 라고 부르며 인터페이스로 생성하게 된다. 단순히 인터페이스를 생성후,
//JpaRepository<Entity클래스, PK 타입>을 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
