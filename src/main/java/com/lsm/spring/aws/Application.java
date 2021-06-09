package com.lsm.spring.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
//테스트를 위해 하는건데
//SpringBootApplication 를 하게 되면 스프링 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정하게 됨 
//SpringApplication이 있는 위치부터 설정을 읽어가기 때문에 프로젝트 최상단에 위치해야 함
//톰캣을 쓰지 않고 검사를 할 수 있다는 거임