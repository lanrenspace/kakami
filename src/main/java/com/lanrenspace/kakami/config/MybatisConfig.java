package com.lanrenspace.kakami.config;

import io.r2dbc.spi.ConnectionFactory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.r2dbc.ReactiveSqlSessionFactory;
import org.apache.ibatis.r2dbc.impl.DefaultReactiveSqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lanrenspace@163.com
 * @Description: mybatis整合
 **/
@Configuration
public class MybatisConfig {

    @Bean
    public ReactiveSqlSessionFactory reactiveSqlSessionFactory(ConnectionFactory connectionFactory) {
        XMLConfigBuilder configBuilder = new XMLConfigBuilder(this.getClass().getResourceAsStream("/mybatis-config.xml"));
        org.apache.ibatis.session.Configuration configuration = configBuilder.parse();
        configuration.addMappers("com.lanrenspace.kakami.mapper");
        return new DefaultReactiveSqlSessionFactory(configuration, connectionFactory);
    }


}
