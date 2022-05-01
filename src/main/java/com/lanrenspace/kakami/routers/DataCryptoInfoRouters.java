package com.lanrenspace.kakami.routers;

import com.lanrenspace.kakami.base.ServerRouters;
import com.lanrenspace.kakami.service.DataCryptoInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Configuration
public class DataCryptoInfoRouters extends ServerRouters {

    public DataCryptoInfoRouters() {
        super("/dataCrypto");
    }

    @Bean
    public RouterFunction<ServerResponse> dataCryptoInfoRouter(DataCryptoInfoService cryptoInfoService) {
        return this.buildGetRoute("/userInfo", cryptoInfoService::generate);
    }

}
