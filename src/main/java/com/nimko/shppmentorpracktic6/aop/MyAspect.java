package com.nimko.shppmentorpracktic6.aop;

import com.nimko.shppmentorpracktic6.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allControllerMethods()")
    public Object logging( ProceedingJoinPoint joinPoint) throws Throwable {
        Object o = null;
       MethodSignature signature = (MethodSignature) joinPoint.getSignature();
       String methodName = signature.getName();
       log.info("{} was call", methodName);
       if (methodName.startsWith("add") || methodName.startsWith("put")) {
           log.info("{} try to add on DB", Arrays.stream(joinPoint.getArgs()).sequential().filter(a -> a instanceof Person).findFirst().get());
       }
       o = joinPoint.proceed();
       log.info("Success for {}", methodName);
       return o;
    }

}
