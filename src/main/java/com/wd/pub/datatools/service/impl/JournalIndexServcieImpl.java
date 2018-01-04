package com.wd.pub.datatools.service.impl;

import com.wd.pub.datatools.config.EsClientConfig;
import com.wd.pub.datatools.entity.mysql.primary.Jinformation;
import com.wd.pub.datatools.module.ElasticFeildModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.wd.pub.datatools.repository.mysql.primary.JinformationRepository;
import com.wd.pub.datatools.service.JournalIndexService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Service("journalIndexService")
public class JournalIndexServcieImpl implements JournalIndexService{

    @Autowired
    JinformationRepository jinformationRepository;

    @Autowired
    private ElasticRepository transportRepository;

    private String indexName = "journal";
    private String typeName = "titles";
    /**
     * 向journal索引中添加status字段
     * @return
     */
    public String addJournalIndexStatus(){
        jinformationRepository.findByStatusIsNotNull().forEach(j -> addToIndex(j));
        return "ok";
    }

    private void addToIndex(Jinformation jinformation){
        ElasticFeildModule elasticFeildModule = new ElasticFeildModule();
        elasticFeildModule.fieldName("status").fieldValue(jinformation.getStatus());
        String id = jinformation.getJguid();
        transportRepository.addField(indexName,typeName,id,elasticFeildModule);
    }
}
