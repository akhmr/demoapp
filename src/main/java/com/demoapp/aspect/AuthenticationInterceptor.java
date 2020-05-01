package com.demoapp.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuthenticationInterceptor {
	
	@Pointcut("@annotation(com.demoapp.annotation.Authenticated)")
    public void authentication() {
    }

	@Around("authentication()")
	public Object authenticate(ProceedingJoinPoint jointPoint) throws Throwable {
		
		System.out.println("authenticating");

		MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
		Method method = methodSignature.getMethod();
		if (null != method) {
			HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			if (null != httprequest) {
				String token = httprequest.getHeader("token");
				if (token == null) {
					token = httprequest.getParameter("token");
				}
			}
		}
		return jointPoint.proceed();

	}

}
