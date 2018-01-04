package com.wd.pub.datatools.repository.elastic;

import com.wd.pub.datatools.module.ElasticFeildModule;


/**
 * Created by DimonHo on 2018/1/4.
 */
public interface ElasticRepository {

    /** 向索引中添加一个字段 */
    public void addField(String index, String type, String id, ElasticFeildModule fieldObj);
}
