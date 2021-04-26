package com.ym.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * RunWith
 *  - 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킴
 *  - Spring Runner 라는 스프링 실행자로 사용함
 *  - 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
 *
 *  WebMvcTest
 *   - 웹에 해당하는 어노테이션을 제공
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired //자동 Bean 주입
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        /**
         * 요청
         *  - param 으로 요청
         *  - 숫자날짜 요청을 할 때는 문자열로 변환해서 요청해야 함
         *
         * 응답
         *  - jsonPath 를 사용해서 응답값을 필드별로 검증함
         *  - $을 기준으로 필드명을 명시
         */
        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
