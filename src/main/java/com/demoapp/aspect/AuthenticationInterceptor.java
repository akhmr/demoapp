package com.demoapp.aspect;

import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.demoapp.annotation.Authenticated;
import com.demoapp.model.UserDto;
import com.demoapp.service.UserService;

@Aspect
@Component
public class AuthenticationInterceptor extends WebContentInterceptor{ 
	
	
	@Autowired
	private UserService userService;
	
	@Pointcut("@annotation(com.demoapp.annotation.Authenticated)")
    public void authentication() {
    }

	@Around("authentication()")
	public Object authenticate(ProceedingJoinPoint jointPoint) throws Throwable {
		
		MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		
		UserDto userDto=userService.getUserByToken(httprequest.getHeader("token"));
		
		Authenticated authenticated =method.getAnnotation(Authenticated.class);
		
		if( authenticated.roleRequired()) {
			Set<String> allowedUrl = userService.getUserPermission(userDto.getCode());
			if(! allowedUrl.contains(httprequest.getRequestURI())) {
				throw new RuntimeException("You are not allowed to access the url");
			}
		}
		
		return jointPoint.proceed();

	}

}
