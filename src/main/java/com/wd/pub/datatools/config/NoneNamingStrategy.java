package com.wd.pub.datatools.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Component
@Configuration
public class NoneNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        // 默认会将表名转成小写，这里不做转换(解决mysql数据库表名大小写敏感的问题)
        String tableName = name.getText();
        return name.toIdentifier(tableName);
    }
}
