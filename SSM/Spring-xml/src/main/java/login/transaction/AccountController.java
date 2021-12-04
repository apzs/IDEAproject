package login.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 无名氏
 * @date 2021/9/16
 * 基于xml的事务控制(Spring2中有基于注解的事务控制)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer("lisa1","lisa2",500);
    }

}
