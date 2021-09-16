package login.transaction.impl;

import login.transaction.AccountDao;
import login.transaction.AccountService;

/**
 * @author 无名氏
 * @date 2021/9/16
 */
public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }
}
