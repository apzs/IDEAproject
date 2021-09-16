package login.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 无名氏
 * @date 2021/9/15
 * 需要在applicationContext.xml中开启AOP自动代理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
//@ContextConfiguration(classes = {SpringConfiguration.class}) 这种情况不行(需要在配置文件中开启自动代理)
public class AOPTest {

    @Autowired
    private TargetInterface target;

    @Test
    public void test1(){
        target.save();
    }
}
