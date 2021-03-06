package br.com.hotmart.challenge.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class BaseRestControllerAspect {

	@Before("execution(public * br.com.hotmart.challenge.controller.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		log.info("==> Início Chamada Rest");
		log.info("==> Controller ( {} )", pjp.getTarget().getClass().getName());
		log.info("==> Método: ( {} )", pjp.getSignature());
	}

	@AfterReturning(value = "execution(* br.com.hotmart.challenge.controller.*Controller.*(..))", returning = "result")
	public void logAfterRestCall(JoinPoint pjp, Object result) throws Throwable {
		log.info("==> Fim Chamada Rest ({})", pjp);

	}

}