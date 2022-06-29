package by.svetlenkaja.travelagency.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* by.svetlenkaja.travelagency.*.*.*.*(..))")
//    @Pointcut("execution(* by.svetlenkaja.travelagency.service.impl.*.*(..))")
    public void allServiceMethods() {
    }

    @Before("allServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOGGER.info( "Call method {} with args: {}", joinPoint.getSignature().getDeclaringTypeName(), Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(JoinPoint joinPoint, RuntimeException e) {
        LOGGER.error("Exception in {}.{}(), messageDetails: {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getMessage());
    }

}