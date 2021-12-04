package com.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author 无名氏
 * @date 2021/9/21
 */
public class ClassCondition implements Condition {
    /**
     *
     * @param conditionContext          上下文对象。用于获取环境，IOC容器，ClassLoader对象
     * @param annotatedTypeMetadata     注解元对象，可以用于获取注解定义的属性值
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
       //需求:导入通过注解属性值value指定坐标后创建Bean

       //获取注解属性值 value
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(MyConditionOnClass.class.getName());
        String[] value = (String[]) map.get("value");
        boolean flag = true;
        try {
            for (String className : value) {
                Class<?> aClass = Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
