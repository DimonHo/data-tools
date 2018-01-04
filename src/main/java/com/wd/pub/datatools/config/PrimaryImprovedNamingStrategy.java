package com.wd.pub.datatools.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Component
@Configuration
public class PrimaryImprovedNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        // 将表名全部转换成大写
        String tableName = name.getText();

        return name.toIdentifier(tableName);
    }
}
