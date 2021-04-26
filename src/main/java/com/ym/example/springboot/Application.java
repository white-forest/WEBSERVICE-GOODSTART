package com.ym.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication - 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정함
 * 이 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 함
 * Application 은 앞으로 만들 프로젝트의 메인 클래스가 됨
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*
        내장 WAS를 실행함
        스프링 부트는 별도로 외부에 WAS 를 두지 않고, 어플리케이션을 실행할 때 내부에서 WAS 를 실행함
        항상 서버에 tomcat 을 설치할 필요가 없고, jar 파일로 실행하면 됨
        항상 같은 환경에서 스프링 부트를 배포할 수 있게 됨
         */
        SpringApplication.run(Application.class, args);
    }
}
