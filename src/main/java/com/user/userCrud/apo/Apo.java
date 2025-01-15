package com.user.userCrud.apo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
@Aspect
@Slf4j
class apo {

//    Logger log= (Logger) LoggerFactory.getLogger(apo.class);

    @Pointcut(value="execution(* com.user.userCrud.*.*.*(..))")
    public void pointcut()
    {

    }

    @Around("pointcut()")
    public Object applicationLog(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=pjp.getSignature().getName();
        String className=pjp.getTarget().getClass().toString();
        Object[]array=pjp.getArgs();
        log.info("Method Called"+className+" :"+ methodName+"()"+": "+" Arguments : "+ mapper.writeValueAsString(array));
        Object object =pjp.proceed();
        log.info("Method Called"+ className+": "+methodName+"()"+": "+" Arguments : "+ mapper.writeValueAsString(object));
        return object;





    }

}

