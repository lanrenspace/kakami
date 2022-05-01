package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.ResultData;
import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.config.UserUtil;
import com.lanrenspace.kakami.entity.DataCryptoInfo;
import com.lanrenspace.kakami.mapper.DataCryptoInfoMapper;
import com.lanrenspace.kakami.service.DataCryptoInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Service
public class DataCryptoInfoServiceImpl extends BaseBeanServiceImpl<DataCryptoInfo, DataCryptoInfoMapper> implements DataCryptoInfoService {

    @Override
    public Mono<ServerResponse> generate(ServerRequest serverRequest) {
        return UserUtil.getUserInfo().flatMap(ResultData::success);
    }
}
