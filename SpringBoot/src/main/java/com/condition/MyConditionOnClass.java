package com.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class)
public @interface MyConditionOnClass {
    String[] value();
}
