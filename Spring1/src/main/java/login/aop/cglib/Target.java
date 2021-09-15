package login.aop.cglib;

/**
 * @author 无名氏
 * @date 2021/9/15
 * cglib代理:基于父类的动态代理技术
 */
public class Target{
    public void save() {
        System.out.println("save running ...");
    }
}
