package com.wd.pub.datatools.repository.elastic;

import com.sun.org.apache.regexp.internal.RE;
import com.wd.pub.datatools.module.ResultModule;
import com.xiaoleilu.hutool.json.JSONObject;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.rest.RestStatus;

import java.util.Map;


/**
 * Created by DimonHo on 2018/1/4.
 */
public interface ElasticRepository {

    /**
     * 创建索引
     * @param index
     * @return
     */
    ResultModule createIndex(String index);

    /**
     * 创建索引
     * @param index
     * @param settings
     * @return
     */
    ResultModule createIndex(String index, Settings settings);

    /**
     * 创建索引
     * @param index
     * @param type
     * @param mapping
     * @return
     */
    ResultModule createIndex(String index, String type,Map<String,Object> mapping);

    /**
     * 创建索引
     * @param index
     * @param type
     * @return
     */
    ResultModule createIndex(String index, String type, Settings settings, Map<String,Object> mapping);

    /**
     * matchAll查询
     * @param index
     * @param type
     * @return
     */
    ResultModule matchAll(String index,String type);

    /**
     * 根据 doc ID 查询
     * @param index
     * @param type
     * @param id
     * @return
     */
    ResultModule getDocById(String index,String type,String id);

    /**
     * 根据doc ID 跟新一个文档
     * @param index
     * @param type
     * @param id
     * @param fieldMap
     * @return
     */
    ResultModule updateFieldById(String index, String type, String id, Map<String,Object> fieldMap);

    /** 更新 */
    ResultModule update(UpdateRequest updateRequest);

    /**
     * 检查文档是否存在
     * @param index
     * @param type
     * @param id
     * @return
     */
    boolean isExistsById(String index, String type, String id);

    /**
     * 滚动获取所有数据，defaultScrollTime=1000*60ms defaultBatchSize=10
     * @param index
     * @param type
     * @return
     */
    ResultModule scrollAll(String index,String type);

    /**
     * 滚动获取所有数据, defaultSize=10
     * @param index
     * @param type
     * @param scrollTime 毫秒ms
     * @return
     */
    ResultModule scrollAll(String index, String type,long scrollTime);

    /**
     * 滚动获取所有数据，defaultScrollTime=1000*60ms
     * @param index
     * @param type
     * @param batchSize 返回的批量条数
     * @return
     */
    ResultModule scrollAll(String index, String type,int batchSize);

    /**
     * 滚动获取所有数据
     * @param index
     * @param type
     * @param scrollTime
     * @param batchSize
     * @return
     */
    ResultModule scrollAll(String index, String type,long scrollTime,int batchSize);

    /**
     * 滚动查询，返回所有字段
     * @param index
     * @param type
     * @param queryBuilder 查询条件
     * @return
     */
    ResultModule scrollByQuery(String index,String type, QueryBuilder queryBuilder);

    /**
     * 滚动获取所有数据，仅返回指定字段
     * @param index
     * @param type
     * @param returnFields 返回字段列表
     * @return
     */
    ResultModule scrollAllReFields(String index,String type, String[] returnFields);

    /**
     * 滚动查询，仅返回指定字段
     * @param index
     * @param type
     * @param queryBuilder 查询条件
     * @param returnFields 返回字段列表
     * @return
     */
    ResultModule scrollByQueryReFields(String index,String type,QueryBuilder queryBuilder,String[] returnFields);

    /**
     * 滚动查询，仅返回指定字段
     * @param index
     * @param type
     * @param queryBuilder
     * @param returnFields
     * @param batchSize
     * @return
     */
    ResultModule scrollByQueryReFields(String index, String type, QueryBuilder queryBuilder, String[] returnFields, int batchSize);


    /**
     *
     * @param scrollId
     * @param scrollTime
     * @return
     */
    ResultModule scrollByScrollId(String scrollId,long scrollTime);
}
