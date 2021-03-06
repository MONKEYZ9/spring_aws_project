package com.lsm.spring.aws.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//여기서 save, findAll 기능을 테스트 할거임
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit단위 테스트가 끝날때마다 수행되는 메소드를 지정하는 것이다.
//    보통은 배포 전 전체 테스트를 수행할 때, 테스트간 데이터 침범을 막기 위해 사용
//    여러 테스트가 동시에 수행되면 테스트 용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시 테스트가 실패할 수 있음
    public void cleanup() {
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 테이블 insert/update 쿼리를 실행한다
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블의 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
// 이쯤되면 드는 생각이 실행된 쿼리를 로그로 볼 수 없는가?
//  applicatio.properties, application.yml등의 파일로 한줄의 코드로 설정할 수 있다.
//    applicatio.properties를 추가하고 spring.jpa.show_sql=true를 넣게 해주면
//    콘솔에서 확인할수 있다 99p

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}
