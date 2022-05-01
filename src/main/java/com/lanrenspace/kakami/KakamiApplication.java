package com.lanrenspace.kakami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@EnableWebFlux
@SpringBootApplication
public class KakamiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakamiApplication.class, args);
    }
}
