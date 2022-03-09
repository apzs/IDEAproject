package com.hjnu.mybatis.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author 无名氏
 * @date 2022/3/8
 * @Description: TODO
 */
public enum SexEnum {
    MAIL(1,"男"),
    FEMAIL(2,"女");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(int sex,String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
