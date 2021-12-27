package aopExam;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyFirstAspect {
	public static int seq = 0;
	
	public void before() {
		System.out.println("Hello before! *** 메소드 호출전 "+ ++seq);
	}
	
	public void afterReturning() {
		System.out.println("Hello afterReturning! *** 메소드 호출후 "+ ++seq);
	}
	
	public Object around(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("Hello around before! *** 메소드 호출전 "+ ++seq);
		Object p = pjp.proceed();
		System.out.println("Hello around after! *** 메소드 호출후 " + ++seq);
		
		return p;
	}
	
	public void afterThrowing() {
		System.out.println("Hello afterThrowing *** 예외 발생후 "+ ++seq);
	}
	
}
