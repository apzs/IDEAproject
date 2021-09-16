package login.transaction.impl;

import login.transaction.AccountDao;
import login.transaction.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 无名氏
 * @date 2021/9/16
 */
@Service
//在类上配置Transactional则该类所有的方法都使用该参数，如果该类与方法都配置了相同参数 则按就近原则
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    //<tx:method name="transfer" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false"/>
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.NOT_SUPPORTED)
    public void xxx(){

    }
}
