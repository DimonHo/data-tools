package com.wd.pub.datatools.service.impl;

import com.wd.pub.datatools.entity.mysql.primary.Jinformation;
import com.wd.pub.datatools.module.ResultModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.wd.pub.datatools.repository.mysql.primary.JinformationRepository;
import com.wd.pub.datatools.service.JournalIndexService;
import com.xiaoleilu.hutool.date.DateUtil;
import org.elasticsearch.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Service("journalIndexService")
public class JournalIndexServcieImpl implements JournalIndexService {

    private static final Logger log = LoggerFactory.getLogger(JournalIndexService.class);
    @Autowired
    JinformationRepository jinformationRepository;

    @Autowired
    private ElasticRepository transportRepository;

    private String indexName = "journal";
    private String typeName = "titles";

    /**
     * 更新journal索引中的status字段（是否已停刊）
     *
     * @return
     */
    public String updateJournalIndexStatus() {
        //从mysql中获取status不为null的数据
        jinformationRepository.findByStatusIsNotNull().forEach(j -> pushToIndex(j));
        return DateUtil.formatDateTime(new Date()) + "：处理完成";
    }

    private void pushToIndex(Jinformation jinformation) {
        String id = jinformation.getJguid();
        Map<String, Object> feildMap = new HashMap<String, Object>();
        feildMap.put("status", jinformation.getStatus());
        ResultModule<RestStatus> restStatus = transportRepository.updateFieldById(indexName, typeName, id, feildMap);
        if (restStatus.getCode()!=200) {
            log.warn(restStatus.getMsg());
        }
    }
}
