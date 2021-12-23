package com.example.aop_test01;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Log4j2
@Component
@Aspect
public class AnnotationHandling {
   // 어노테이션 핸들링
//   @Around("execution(* com.example..*(..))")
   @Around("@annotation(LogAnnotation)")
   public Object handling(ProceedingJoinPoint joinPoint) throws Throwable {

      try {
         // Service Method 실행
         Object result = joinPoint.proceed();
         log.info("어노테이션 핸들링");

         try {
            // Method 객체 참조
            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            Method method = ms.getMethod();

            // Method에 선언된 @LogAnnotation 참조
            Annotation annotation = method.getAnnotation(LogAnnotation.class);
            LogAnnotation logAnnotation = null;

            if (annotation != null) {
               logAnnotation = (LogAnnotation)annotation;

               log.info(logAnnotation.name());
               log.info(logAnnotation.keyword());
            }

         } catch (Exception e) {
            throw e;
         }

         return result;

      } catch (Exception e) {
         throw e;
      }
   }
}
