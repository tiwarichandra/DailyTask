package com.tiwari.springtrans.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracker {

    // non-functional code need to dump here


    @Pointcut("within(com.tiwari.springtrans.service.*) || within(com.tiwari.springtrans.repo.*)")
    public void logMethodPointCut() {

    }





    // when the logic here should run before/after or before and after the method
//    @Before("logMethodPointCut()")
//    public void logBeforeMethodCall() {
////        System.out.println("execute this line before any method");
//        System.out.println("method is starting..");
//    }

//    @After("logMethodPointCut()")
//    public void logAfterMethodCall() {
////        System.out.println("execute this line before any method");
//        System.out.println("method Execution completed..");
//    }

    @Around("logMethodPointCut()")
    public Object logBeforeMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("execute this line before any method");

        System.out.println("method start: "+proceedingJoinPoint.getSignature().getName());
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("method completed: "+proceedingJoinPoint.getSignature().getName());
        return proceed;
    }


}
