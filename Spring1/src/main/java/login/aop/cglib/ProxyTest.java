package login.aop.cglib;

import login.aop.jdk.Advice;
import login.aop.jdk.Target;

/**
 * @author 无名氏
 * @date 2021/9/15
 * cglib代理:基于父类的动态代理技术
 */
public class ProxyTest {

    public static void main(String[] args) {
        //目标对象
        login.aop.jdk.Target target = new Target();
        //增强对象
        login.aop.jdk.Advice advice = new Advice();
    }
}
