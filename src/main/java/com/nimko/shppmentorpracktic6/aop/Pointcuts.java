package com.nimko.shppmentorpracktic6.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.nimko.shppmentorpracktic6.controllers.PersonController.*(..))")
    public void allControllerMethods(){}
}
