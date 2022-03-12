package edu.uestc.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    //前置通知
    @Before(value = "execution(* edu.uestc.spring.aop.User.add())")
    public void before(){
        System.out.println("before..........");
    }

    // 最终通知，有没有异常都执行
    @After(value = "execution(* edu.uestc.spring.aop.User.add())")
    public void after(){

    }
    // 方法返回结果之后执行，后置通知，发生异常不会执行
    @AfterReturning(value = "execution(* edu.uestc.spring.aop.User.add())")
    public void afterReturing(){

    }
    // 异常通知
    @AfterThrowing(value = "execution(* edu.uestc.spring.aop.User.add())")
    public void afterThrowing(){

    }

    // 环绕通知,方法之前和方法之后都通知
    @Around(value = "execution(* edu.uestc.spring.aop.User.add())")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后....");

    }
}
