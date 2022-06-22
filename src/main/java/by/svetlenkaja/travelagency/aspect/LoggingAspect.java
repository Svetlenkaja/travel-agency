package by.svetlenkaja.travelagency.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* by.svetlenkaja.travelagency.service.impl.*.*(..))")
    public void allServiceMethods() {

    }

    @Before("allServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info( "Call method {} with args: {}", joinPoint.getSignature().getDeclaringTypeName(), Arrays.toString(joinPoint.getArgs()));
    }

//    @AfterReturning(pointcut = "allMethods()", returning = "someValue")
//    public void afterReturningAdvice(Object someValue) {

//    }

    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(JoinPoint joinPoint, RuntimeException e) {
        LOGGER.error("Exception in {}.{}(), messageDetails: {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getMessage());
    }

//    @Around("allServiceMethods()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (LOGGER.isDebugEnabled()) {
//            LOGGER.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//        }
//        try {
//            Object result = joinPoint.proceed();
//            if (LOGGER.isDebugEnabled()) {
//                LOGGER.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                        joinPoint.getSignature().getName(), result);
//            }
//            return result;
//        } catch (IllegalArgumentException e) {
//            LOGGER.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//            throw e;
//        }
//    }

}