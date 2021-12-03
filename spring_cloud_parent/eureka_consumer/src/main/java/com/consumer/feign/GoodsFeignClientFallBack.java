package com.consumer.feign;

import com.consumer.domain.Goods;
import org.springframework.stereotype.Component;

/**
 * @author 无名氏
 * @date 2021/11/29
 * @Description: TODO
 * 服务消费方
 * 1. feign 组件已经集成了hystrix组件。
 * 2.定义feign 调用接实现类，复写方法，即降级方法(还要添加到容器中)
 * 3.在@FeignClient注解中使用fallback属性设置降级处理类。
 * 4.配置开启feign.hystrix.enabled = true
 */
@Component
public class GoodsFeignClientFallBack implements GoodsFeignClient{
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = new Goods(0,"consumer降级了...",0);
        return goods;
    }
}
