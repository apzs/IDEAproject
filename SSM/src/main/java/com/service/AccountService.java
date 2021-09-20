package com.service;

import com.domain.Accounts;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
public interface AccountService {

    void save(Accounts accounts);

    List<Accounts> findAll();
}
