package bsu.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * User: iason
 * Date: 01.06.14
 */
@Aspect
public class LoggingAspect {
    @Around("execution(*  bsu.training.aop.TestBean.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before");
        Object ret = pjp.proceed();
        System.out.println("After");
        return ret;
    }
}

