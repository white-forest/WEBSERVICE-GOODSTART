package com.ym.example.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /**
         * assertThat
         *  - assertj 테스트 검증 라이브러리의 검증 메소드
         *  - 검증하고 싶은 대상을 인자로 받음
         * isEqualTo
         *  - assertj 의 동등 비교 메소드
         *  - assertThat 에 있는 값과 isEqualTo 의 값을 비교해서 같을 때만 성공
         *
         * Junit 의 assertThat 과 assertj 의 assertThat 을 비교해 볼 수 있음
         *
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
