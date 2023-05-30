package fa.ru.aop.aspect;


import fa.ru.aop.entities.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class LoggingAspect {
    @Around("execution(public Integer fa.ru.aop.dao.AccountDAO.makeSomeOperation(..)) && args(a, b)")
    public Integer beforeAdvice(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
        if (a != -1) {
            return (Integer) joinPoint.proceed();
        } else {
            return null;
        }
    }


}
