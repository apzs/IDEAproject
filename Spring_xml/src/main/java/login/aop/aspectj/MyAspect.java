package login.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 无名氏
 * @date 2021/9/15
 * aspect:切面
 */
public class MyAspect {

    public void myBefore(){
        System.out.println("前置增强...");
    }

    public void myAfterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点（切点）
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        //执行切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后...");
        return proceed;
    }

    private void myAfterThrowing(){
        System.out.println("异常抛出增强...");
    }

    private void myAfter(){
        System.out.println("最终增强...");
    }
}
