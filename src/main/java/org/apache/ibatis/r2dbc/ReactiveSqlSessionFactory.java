package org.apache.ibatis.r2dbc;


import io.r2dbc.spi.ConnectionFactory;
import org.apache.ibatis.session.Configuration;

import java.io.Closeable;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface ReactiveSqlSessionFactory extends Closeable {

    ReactiveSqlSession openSession();

    Configuration getConfiguration();

    ConnectionFactory getConnectionFactory();
}
