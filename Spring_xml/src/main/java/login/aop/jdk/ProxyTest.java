package login.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 无名氏
 * @date 2021/9/15
 * jdk代理：基于接口的动态代理技术
 */
public class ProxyTest {

    public static void main(String[] args) {
        /**调用代理对象的任何方法 实质执行的都是invoke方法
         * @param proxy  代理对象
         * @param method 目标方法
         * @param args   传递参数
         * @return       动态生成的代理对象
         * @throws Throwable
         */

        //目标对象
        Target target = new Target();
        //增强对象
        Advice advice = new Advice();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();             //前置增强
                Object invoke = method.invoke(target,args);  //执行目标方法
                advice.afterReturning();     //后置增强
                return invoke;
            }
        };

         TargetInterface proxy =(TargetInterface)
                 Proxy.newProxyInstance(Target.class.getClassLoader(), //目标对象类加载器
                         Target.class.getInterfaces(),                 //目标对象相同的接口字节码对象数组
                         invocationHandler
                 );

         //调用代理对象的方法
        proxy.save();
    }
}
