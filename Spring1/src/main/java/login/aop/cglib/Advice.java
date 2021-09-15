package login.aop.cglib;

/**
 * @author 无名氏
 * @date 2021/9/15
 * 增强（通知）
 */
public class Advice {

    public void before(){
        System.out.println("前置增强。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。");
    }
}
