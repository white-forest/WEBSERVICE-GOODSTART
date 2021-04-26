package com.ym.example.springboot.web;

import com.ym.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
 * ResponseBody 어노테이션을 메소드마다 선언했던 걸 한 번에 사용할 수 있게 해줌
 */
@RestController
public class HelloController {

    /**
     * HTTP METHOD 인 Get 의 요청을 받을 수 있는 API 를 만들어줌
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * RequestParam 어노테이션은 외부에서 API로 넘긴 파라미터를 가져오는 역할을 수행합니다.
     * @param name
     * @param amount
     * @return
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
