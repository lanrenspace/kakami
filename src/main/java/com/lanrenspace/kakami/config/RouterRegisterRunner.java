package com.lanrenspace.kakami.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.Map;

/**
 * @Author lanrenspace@163.com
 * @Description: 路由注册
 **/
@Slf4j
@Component
public class RouterRegisterRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Map<String, RouterFunction> routerFunctionMap = ApplicationContextHelper.getBeans(RouterFunction.class);
        routerFunctionMap.forEach((k, v) -> {
            log.info("k:{}",k);
        });
        log.info("router function size: {}", routerFunctionMap.keySet().size());
    }
}
