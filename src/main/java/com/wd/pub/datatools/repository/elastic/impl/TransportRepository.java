package com.wd.pub.datatools.repository.elastic.impl;

import com.wd.pub.datatools.module.ElasticFeildModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.xiaoleilu.hutool.date.DateUtil;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Repository("transportRepository")
public class TransportRepository implements ElasticRepository{
    private static final Logger log = LoggerFactory.getLogger(TransportRepository.class);
    @Autowired
    TransportClient client;
    @Override
    public void addField(String index, String type, String id, ElasticFeildModule fieldObj) {
        Map<String,Object> map = client.prepareGet(index,type,id).get().getSource();
        if (map!=null){
            map.put(fieldObj.getFieldName(),fieldObj.getFieldValue());
            client.prepareUpdate(index,type,id).setDoc(map).get();
        }else{
            log.info("{}:[{}]在索引中未找到", DateUtil.formatTime(new Date()),id);
        }
    }

}
