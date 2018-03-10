package com.wd.pub.datatools.repository.elastic.impl;

import com.wd.pub.datatools.module.ResultModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.wd.pub.datatools.utils.RestClientRequestUtils;
import com.wd.pub.datatools.utils.RestClientUrlUtils;
import com.wd.pub.datatools.utils.ResultUtils;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.lang.Console;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by DimonHo on 2018/1/5.
 */
@Repository("restClientRepository")
public class RestClientRepository implements ElasticRepository {

    private static final Logger log = LoggerFactory.getLogger(RestClientRepository.class);

    @Override
    public ResultModule<JSONObject> updateFieldById(String index, String type, String id, Map<String, Object> fieldMap) {
        return null;
    }

    @Override
    public ResultModule<RestStatus> update(UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public boolean isExistsById(String index, String type, String id) {
        return false;
    }

    @Override
    public ResultModule scrollAll(String index, String type) {
        return scrollAll(index, type, 1000 * 60, 10);
    }

    @Override
    public ResultModule scrollAll(String index, String type, long scrollTime) {
        return scrollAll(index, type, scrollTime, 10);
    }

    @Override
    public ResultModule scrollAll(String index, String type, int batchSize) {
        return scrollAll(index, type, 1000 * 60, batchSize);
    }

    @Override
    public ResultModule scrollAll(String index, String type, long scrollTime, int batchSize) {
        String dsl = "{\"size\":" + batchSize + "}";
        return httpScrollSearch(index, type, scrollTime, dsl);
    }

    private ResultModule<JSONObject> httpScrollSearch(String index, String type, long scrollTime, String dsl) {
        String url = RestClientUrlUtils.scrollSearchUrl(index, type, scrollTime);
        JSONObject resObj = RestClientRequestUtils.post(url, dsl, 2000);
        if (resObj == null) {
            return ResultUtils.error(0, "未找到数据");
        }
        return ResultUtils.success(resObj);
    }


    @Override
    public ResultModule<JSONObject> scrollByQuery(String index, String type, QueryBuilder queryBuilder) {
        return scrollByQueryReFields(index,type,QueryBuilders.matchAllQuery(),null);
    }

    @Override
    public ResultModule<JSONObject> scrollAllReFields(String index, String type, String[] returnFields) {
        return scrollByQueryReFields(index,type,QueryBuilders.matchAllQuery(),returnFields);
    }

    @Override
    public ResultModule<JSONObject> scrollByQueryReFields(String index, String type, QueryBuilder queryBuilder, String[] returnFields) {
        return scrollByQueryReFields(index,type,queryBuilder,returnFields,10);
    }

    @Override
    public ResultModule<JSONObject> scrollByQueryReFields(String index, String type, QueryBuilder queryBuilder, String[] returnFields,int batchSize) {
        String queryDsl = queryToDsl(queryBuilder, returnFields,batchSize);
        return httpScrollSearch(index, type, 1000 * 60, queryDsl);
    }


    @Override
    public ResultModule<JSONObject> scrollByScrollId(String scrollId, long scrollTime) {
        String url = RestClientUrlUtils.scrollSearchByScrollIdUrl(scrollId,scrollTime);
        JSONObject jsonResp = RestClientRequestUtils.get(url,2000);
        Console.log(jsonResp);
        return ResultUtils.success(jsonResp);
    }

    private ResultModule<JSONObject> httpSearch(String index, String type, String queryDsl) {
        String url = RestClientUrlUtils.searchUrl(index, type);
        JSONObject respJson = RestClientRequestUtils.post(url, queryDsl, 2000);
        if (respJson == null) {
            return ResultUtils.error(0, "未找到数据");
        }
        return ResultUtils.success(respJson);
    }

    @Override
    public ResultModule createIndex(String index) {
        return null;
    }

    @Override
    public ResultModule createIndex(String index, Settings settings) {
        return null;
    }

    @Override
    public ResultModule createIndex(String index, String type, Map<String, Object> mapping) {
        return null;
    }

    @Override
    public ResultModule createIndex(String index, String type, Settings settings, Map<String, Object> mapping) {
        return null;
    }


    @Override
    public ResultModule<JSONObject> matchAll(String index, String type) {
        return httpSearch(index, type, "{\"query\":{\"match_all\":{}}}");
    }

    @Override
    public ResultModule getDocById(String index, String type, String id) {
        String url = RestClientUrlUtils.getDocByIdUrl(index, type, id);
        return ResultUtils.success(RestClientRequestUtils.get(url, 2000));
    }


    /**
     * queryBuilder对象转字符串
     *
     * @param queryBuilder
     * @return
     */
    private String queryToDsl(QueryBuilder queryBuilder) {
        return "{\"query\":" + queryBuilder.toString() + "}";
    }

    private String queryToDsl(QueryBuilder queryBuilder, String[] returnFields) {
        return queryToDsl(queryBuilder,returnFields,10);
    }

    private String queryToDsl(QueryBuilder queryBuilder, String[] returnFields,int size) {
        return queryToDsl(queryBuilder,returnFields,size,0);
    }

    private String queryToDsl(QueryBuilder queryBuilder, String[] returnFields,int size,int from) {
        String dsl = "{" +
                "\"size\":"+size + "," +
                "\"from\":"+ from + ",";
        if (returnFields != null && returnFields.length!=0){
            dsl += "\"_source\":" + formatReturnFields(returnFields) + ",";
        }
        dsl += "\"query\":" + queryBuilder.toString() + "}";
        return dsl;
    }

    private String formatReturnFields(String[] returnFields) {
        String result = "[";
        for (int i = 0; i < returnFields.length; i++) {
            result += i < returnFields.length - 1 ? "\"" + returnFields[i] + "\"," : "\"" + returnFields[i] + "\"";
        }
        result += "]";
        return result;
    }
}
