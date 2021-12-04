package login.aop.cglib;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 无名氏
 * @date 2021/9/15
 * cglib代理:基于父类的动态代理技术
 */
public class ProxyTest {

    public static void main(String[] args) {
        //目标对象
        Target target = new Target();
        //增强对象
        Advice advice = new Advice();


        //返回值 就是动态生成的代理对象 基于cglib

        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();             //前置增强
                Object invoke = method.invoke(target,args);  //执行目标方法
                advice.afterReturning();     //后置增强
                return invoke;
            }
        });
        //4.创建代理对象
        Target proxy =(Target) enhancer.create();

        proxy.save();
    }
}
