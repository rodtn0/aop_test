package com.example.aop_test01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
class Service {

   @LogAnnotation(name = "황인주", keyword = "바보")
   public void method1() {
      log.info("method1 출력");
   }

   @LogAnnotation(name = "김경수", keyword = "천재")
   public void method2() {
      log.info("method2 출력");
   }
}
