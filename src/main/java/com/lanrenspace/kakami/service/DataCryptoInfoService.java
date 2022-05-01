package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.entity.DataCryptoInfo;
import com.lanrenspace.kakami.mapper.DataCryptoInfoMapper;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface DataCryptoInfoService extends IBaseBeanService<DataCryptoInfo, DataCryptoInfoMapper> {

    /**
     * 生成
     *
     * @return
     */
    Mono<ServerResponse> generate(ServerRequest serverRequest);
}
