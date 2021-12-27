package aopExam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class MySecondAspect {
	public static int seq = 0;
	
	public void before(JoinPoint jp) {
		System.out.println("Hello before! *** 메소드 호출전 "+ ++seq);
		Signature sig = jp.getSignature();
		System.out.println("메소드 이름 ==> "+ sig.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수 ==> " + obj[0]);
	}
	
	public void afterReturning(JoinPoint jp, Object product) {
		System.out.println("Hello afterReturning! *** 메소드 호출후 "+ ++seq);
		Signature sig = jp.getSignature();
		System.out.println("메소드 이름 ==> "+ sig.getName());
		Object[] obj = jp.getArgs();
		System.out.println("인수 ==> "+ obj[0]);
		System.out.println("결과 ==> "+ product);
	}
	
	public Object around(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("Hello around before! *** 메소드 호출전 "+ ++seq);
		
		Signature sig = pjp.getSignature();
		System.out.println("메소드 이름 ==> " + sig.getName());
		Object[] obj = pjp.getArgs();
		System.out.println("인수 ==> " + obj[0]);
		
		Object p = pjp.proceed();
		
		System.out.println("Hello around after! *** 메소드 호출후 " + ++seq);
		
		return p;
	}
	
	public void afterThrowing(Exception e) {
		System.out.println("Hello afterThrowing *** 예외 발생후 "+ ++seq);
		System.out.println("예외 내용 ==> " + e.getMessage());
	}
	
}
