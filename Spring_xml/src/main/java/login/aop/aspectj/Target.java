package login.aop.aspectj;

/**
 * @author 无名氏
 * @date 2021/9/15
 * jdk代理：基于接口的动态代理技术
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        int i = 1/0;
        System.out.println("save running ...");
    }
}
