package com.crazycoder.crazyharborbff.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class TransactionAudit {

    // todo: getmapping does not work
    private final String generalControllerPointCut = "((within(*..controller..*) && (@annotation(org.springframework.web.bind.annotation.PostMapping) ||"
            + "@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
            + "@annotation(org.springframework.web.bind.annotation.RequestMapping) || "
            + "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||"
            + "@annotation(org.springframework.web.bind.annotation.PutMapping))))";


    @AfterReturning(value = generalControllerPointCut, returning = "returnedValue")
    public void logTransaction(JoinPoint joinPoint) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        log.info("transaction target class -> " + proceedingJoinPoint.getTarget().getClass());
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        log.info("transaction method -> " + signature.getName());
    }

    @AfterThrowing(value = generalControllerPointCut, throwing = "e")
    public void logThrownException(JoinPoint joinPoint, Exception e) { // todo baseException geç

        String message = e.getMessage();
        Throwable cause = e.getCause();

        log.error("exception thrown, Message: " + message + "\n" + "Cause: " + cause);

    }
}
