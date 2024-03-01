package dev.rost.afterthrowingtwice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
class AdvisedServiceAspect {

    @AfterThrowing(pointcut = "bean(advisedService)", throwing = "e")
    void afterThrowingException(Exception e) {
        System.out.println("AdvisedServiceAspect.afterThrowingException: " + e.getClass().getSimpleName());
    }

    @AfterThrowing(pointcut = "bean(advisedService)", throwing = "e")
    void afterThrowingException(RuntimeException e) {
        System.out.println("AdvisedServiceAspect.afterThrowingRuntimeException: " + e.getClass().getSimpleName());
    }
}
