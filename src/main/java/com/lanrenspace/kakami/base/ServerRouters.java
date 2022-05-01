package com.lanrenspace.kakami.base;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * @Author lanrenspace@163.com
 * @Description: 对外路由抽象
 **/
public abstract class ServerRouters {

    /**
     * 服务跟路径
     */
    private static String ROOT_PATTERN = "";


    public ServerRouters(String rootPattern) {
        ROOT_PATTERN = rootPattern;
    }


    /**
     * 构建get路由
     *
     * @param path
     * @param handlerFunction
     * @param <T>
     * @return
     */
    protected <T extends ServerResponse> RouterFunction<T> buildGetRoute(String path, HandlerFunction<T> handlerFunction) {
        return this.buildGetRoute(path, handlerFunction, MediaType.APPLICATION_JSON);
    }

    /**
     * 构建get路由
     *
     * @param path
     * @param handlerFunction
     * @param mediaType
     * @param <T>
     * @return
     */
    protected <T extends ServerResponse> RouterFunction<T> buildGetRoute(String path, HandlerFunction<T> handlerFunction, MediaType mediaType) {
        if (null == mediaType) {
            mediaType = MediaType.APPLICATION_JSON;
        }
        return RouterFunctions.route(this.buildGetRequestPredicate(path, mediaType), handlerFunction);
    }


    /**
     * 构建post路由
     *
     * @param path
     * @param handlerFunction
     * @param <T>
     * @return
     */
    protected <T extends ServerResponse> RouterFunction<T> buildPostRoute(String path, HandlerFunction<T> handlerFunction) {
        return this.buildPostRoute(path, handlerFunction, MediaType.APPLICATION_JSON);
    }


    /**
     * 构建post路由
     *
     * @param path
     * @param handlerFunction
     * @param mediaType
     * @param <T>
     * @return
     */
    protected <T extends ServerResponse> RouterFunction<T> buildPostRoute(String path, HandlerFunction<T> handlerFunction, MediaType mediaType) {
        if (null == mediaType) {
            mediaType = MediaType.APPLICATION_JSON;
        }
        return RouterFunctions.route(this.buildPostRequestPredicate(path, mediaType), handlerFunction);
    }


    /**
     * get
     *
     * @param path
     * @param mediaType
     * @return
     */
    protected RequestPredicate buildGetRequestPredicate(String path, MediaType mediaType) {
        return RequestPredicates.GET(ROOT_PATTERN + path).and(RequestPredicates.accept(mediaType));
    }

    /**
     * post
     *
     * @param path
     * @param mediaType
     * @return
     */
    protected RequestPredicate buildPostRequestPredicate(String path, MediaType mediaType) {
        return RequestPredicates.POST(ROOT_PATTERN + path).and(RequestPredicates.accept(mediaType));
    }
}
