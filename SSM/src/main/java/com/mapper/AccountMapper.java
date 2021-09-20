package com.mapper;

import com.domain.Accounts;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
public interface AccountMapper {
    void save(Accounts accounts);

    List<Accounts> findAll();
}
