package com.example.jwt.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * LogAspect
 *
 * @author lijiehua
 * @date 2018-05-28
 */
@Slf4j
// @Aspect
@Component
public class LogAspect {

    // @Before 在切入点开始处切入内容
    // @After 在切入点结尾处切入内容
    // @AfterReturning 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
    // @AfterThrowing 用来处理当切入内容部分抛出异常之后的处理逻辑
    // @Around 在切入点前后切入内容，并自己控制何时执行切入点自身的内容

    @Pointcut("execution(* com.example.jwt.controller..*.*(..))")
    void log() {
        log.info("Pointcut:log()");
    }


    @Before("log()")
    void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        log.info("Before 目标方法名:" + methodName + ",参数为:" + args);
        log.info("Before");
    }

    @After("log()")
    void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        log.info("After 目标方法名:" + methodName + ",参数为:" + args);
        log.info("After");
    }

    @AfterReturning(pointcut = "log()", returning = "ret")
    void afterReturning(JoinPoint joinPoint, Object ret) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        log.info("AfterReturning 目标方法名:" + methodName + ",参数为:" + args);
        log.info("AfterReturning 返回结果为:" + ret);
    }

    @AfterThrowing(pointcut = "log()", throwing = "ex")
    void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        log.info("AfterThrowing 目标方法名:" + methodName + ",参数为:" + args);
        log.info("AfterThrowing 异常为:" + ex);
    }

    @Around("log()")
    Object around(ProceedingJoinPoint proceedingJoinPoint) {
        String methodName = proceedingJoinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
        log.info("Around 目标方法名:" + methodName + ",参数为:" + args);

        // result为连接点的放回结果
        Object result = null;
        // 前置通知
        log.info("Before");
        // 执行目标方法
        try {
            result = proceedingJoinPoint.proceed();
            // 后置通知
            log.info("After");
        } catch (Throwable e) {
            // 异常通知
            log.info("AfterThrowing 异常为:" + e);
        }
        // 返回通知
        log.info("AfterReturning 返回结果为:" + result);
        return result;
    }

}
