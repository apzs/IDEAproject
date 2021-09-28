package com.service.impl;

import com.domain.Accounts;
import com.mapper.AccountMapper;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Accounts accounts) {
        accountMapper.save(accounts);
    }

    @Override
    public List<Accounts> findAll() {
        List<Accounts> accountsList = accountMapper.findAll();
        return accountsList;
    }
}
