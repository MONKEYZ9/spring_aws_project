package com.lsm.spring.aws.web;


import com.lsm.spring.aws.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//JSON을 반환하는 컨트롤러로 만드는거임
//예전에는 ResposeBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 됨
@RestController
public class HelloController {
//    HTTP Method에서 Get요청을 받을 수 있는 API를 만들어 주는 것임
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

//    @GetMapping("/hello/dto")
//    public HelloResponseDto helloDto(@RequestParam("name") String name,
//                                     @RequestParam("amount") int amount) {
//        return new HelloResponseDto(name, amount);
//    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
