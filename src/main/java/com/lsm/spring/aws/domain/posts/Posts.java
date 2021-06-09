package com.lsm.spring.aws.domain.posts;


import com.lsm.spring.aws.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter // getter 메소드를 자동으로 생성하게 된다
// 보통 자바빈 규약을 생각하면서 getter setter를 다 만들어 냈는데 이렇게 되면
//해당클래스들의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분 할 수 없어
//차후 기능 변경시 정말 복잡해짐
//그래서 Entity 클래스에서는 절대 Setter 메소드를 만들지 않음
//그럼 DB에 값을 어떻게 삽입을 할까?
// 이는 생성자를 통해 최종값을 채운후 DB에 삽입하는 것이고 ㄱ
// 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다.
//Builder를 통해서 제공되는 빌더 클래스를 사용한다
//생성자나 빌더나 생성시점에 값을 채워주는 역할은 똑같다

@NoArgsConstructor // 기본생성자를 자동 추가하는 효과를 낸다
@Entity

public class Posts extends BaseTimeEntity {

    @Id // 프라이머리키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생설규칙을 나타낸다
//    책 90쪽에 설명이 잘 되어있음
    private Long id;

    @Column(length = 500, nullable = false) // varchar은 255가 기본인데 늘리고 싶으면 length해서 늘리면 된다
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;


    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
