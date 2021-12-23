package com.example.aop_test01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@SpringBootApplication
public class AopTest01Application {

   public static void main(String[] args) {
      SpringApplication.run(AopTest01Application.class, args);

      Service service = new Service();

      service.method1();

      service.method2();

   }
}
