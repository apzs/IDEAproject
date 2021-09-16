package login.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 无名氏
 * @date 2021/9/15
 * aspect:切面
 */
@Component("myAspect")
@Aspect     //标注当前类是一个Aspect切面类
public class MyAspect {

    //配置前置通知
    @Before("execution(public void login.aspectj.Target.*(..))")
    public void myBefore(){
        System.out.println("前置增强...");
    }

    @AfterReturning("MyAspect.myPointcut()")
    public void myAfterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点（切点）
    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        //执行切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后...");
        return proceed;
    }

    @AfterThrowing("myPointcut()")
    private void myAfterThrowing(){
        System.out.println("异常抛出增强...");
    }

    @After("myPointcut()")
    private void myAfter(){
        System.out.println("最终增强...");
    }

    @Pointcut("execution(public void login.aspectj.Target.*(..))")
    private void myPointcut(){

    }
}
