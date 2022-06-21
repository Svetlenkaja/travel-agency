package by.svetlenkaja.travelagency.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

    @Pointcut("execution(* by.svetlenkaja.travelagency.service.impl.UserDetailsServiceImpl.*(..))")
    public void loadUserByUsername() {

    }

    @Before("loadUserByUsername()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice.");
    }

    @After("loadUserByUsername()")
    public void afterAdvice() {
        System.out.println("afterAdvice.");
    }

    @AfterReturning(pointcut = "loadUserByUsername()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        System.out.println("Value: " + someValue.toString());
    }

    @AfterThrowing(pointcut = "loadUserByUsername()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(JoinPoint jp, UsernameNotFoundException e) {
        System.out.println("We have an exception here: " + e.toString());
    }

}