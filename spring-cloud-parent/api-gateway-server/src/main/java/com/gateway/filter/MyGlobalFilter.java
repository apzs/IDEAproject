package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 无名氏
 * @date 2021/12/4
 * @Description: 自定义全局网关过滤器
 * 需要实现GlobalFilter和Ordered接口
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("全局过滤器执行了...");
        //放行
        return chain.filter(exchange);
    }

    /**
     * 对过滤器进行排序,数值越小，越先执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
