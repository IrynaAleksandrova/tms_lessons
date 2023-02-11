package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RaceAspect {

    @Pointcut("@annotation(org.example.aop.MyBenchmark)")
    public void pointCutForBenchmark() {}

    @Around("pointCutForBenchmark()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        log.info("Забег по методу " + point.getSignature().getName() + " стартовал!");
        long begin = System.currentTimeMillis();
        Object result = point.proceed();

        log.info("Забег по методу " + point.getSignature().getName() + " окончен!");
        long end = System.currentTimeMillis();
        long around = end - begin;

        log.info("Длительность забегов составила " + around + " миллисекунд");
        return result;
    }
}
