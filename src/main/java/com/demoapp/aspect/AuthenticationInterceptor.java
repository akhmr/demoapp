package com.demoapp.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.demoapp.annotation.Authenticated;

@Aspect
@Component
public class AuthenticationInterceptor extends WebContentInterceptor{
	
	@Pointcut("@annotation(com.demoapp.annotation.Authenticated)")
    public void authentication() {
    }

	@Around("authentication()")
	public Object authenticate(ProceedingJoinPoint jointPoint) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Authenticated authenticated =method.getAnnotation(Authenticated.class);
		
		
		if (null != method) {
			HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			
			String uri =httprequest.getRequestURI();
			System.out.println("Uri "+uri);
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
