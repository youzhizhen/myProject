package com.liying;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;


@Aspect()
@Order(2)
public class LogAspect {

    @Before(value="execution(* com.liying.service.*.*(..))")
    // 前置通知
    public void beforeAdvice(JoinPoint point) {
    
        System.out.println("===========before advice, param");
        Object[] params = point.getArgs();
        System.out.println(params[0]);
        System.out.println(params[1]);
    }

    // 后置最终通知
    @After(value="execution(* com.liying.service.*.*(..))")
    public void afterFinallyAdvice(JoinPoint point) {
        System.out.println("===========after finally advice, param");
    }
    
    // 后置最终通知
    @Around(value="execution(* com.liying.service.*.*(..))")
    public void throwAdvice1(ProceedingJoinPoint  point) throws Throwable {
        System.out.println("===========1 Around before is running!");
        Object[] args = {"liying", 11};
        point.proceed(args );
        System.out.println("===========1 Around after is running!");
    }
    
    // 后置最终通知
    @Around(value="execution(* com.liying.service.*.*(..))")
    public void throwAdvice2(ProceedingJoinPoint  point) throws Throwable {
        System.out.println("===========2 Around before is running!");
        Object[] args = {"liying", 11};
        point.proceed(args );
        System.out.println("===========2 Around after is running!");
    }
}
