package com.wd.pub.datatools.repository.elastic.impl;

import com.wd.pub.datatools.module.ResultModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.wd.pub.datatools.utils.ResultUtils;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.engine.DocumentMissingException;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.rest.RestUtils;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by DimonHo on 2018/1/4.
 */
@Repository("transportRepository")
public class TransportRepository implements ElasticRepository{

    private static final Logger log = LoggerFactory.getLogger(TransportRepository.class);

    @Autowired
    TransportClient client;

    public TransportClient getClient() {
        return client;
    }

    @Override
    public ResultModule<SearchResponse> matchAll(String index, String type) {
        SearchResponse response = client.prepareSearch(index).setTypes(type).get();
        return ResultUtils.success(response);
    }

    @Override
    public ResultModule<GetResponse> getDocById(String index, String type, String id) {
        GetResponse response = client.prepareGet(index,type,id).get();
        return ResultUtils.success(response);
    }

    @Override
    public ResultModule updateFieldById(String index, String type, String id, Map<String,Object> fieldMap) {
        try{
            RestStatus response = client.prepareUpdate(index,type,id).setDoc(fieldMap).get().status();
            return ResultUtils.success(response);
        }catch (DocumentMissingException e){
            log.debug("Document：{}未找到",id);
            return ResultUtils.error(304,"DocumentMissingException");
        }
    }

    @Override
    public ResultModule<RestStatus> update(UpdateRequest updateRequest) {
        ResultModule resultModule = new ResultModule();
        try {
            RestStatus restStatus = client.update(updateRequest).get().status();
            resultModule = ResultUtils.success(restStatus);
        } catch (InterruptedException e) {
            e.printStackTrace();
            resultModule = ResultUtils.error(500,"InterruptedException");
        } catch (ExecutionException e) {
            e.printStackTrace();
            resultModule = ResultUtils.error(500,"ExecutionException");
        }
        return resultModule;
    }

    @Override
    public boolean isExistsById(String index, String type, String id) {
        return client.prepareGet(index,type,id).get().isExists();
    }

    @Override
    public ResultModule<SearchResponse> scrollAll(String index, String type) {
        return scrollAll(index,type,1000*10,10);
    }

    @Override
    public ResultModule<SearchResponse> scrollAll(String index, String type, long timeValue) {
        return scrollAll(index,type,timeValue,10);
    }

    @Override
    public ResultModule<SearchResponse> scrollAll(String index, String type, int batchSize) {
        return scrollAll(index,type,1000*60,batchSize);
    }

    @Override
    public ResultModule<SearchResponse> scrollAll(String index, String type, long timeValue, int batchSize) {
        SearchResponse response = client.prepareSearch(index).setTypes(type)
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(TimeValue.timeValueMillis(timeValue))
                .setSize(batchSize)
                .get();
        return ResultUtils.success(response);
    }

    @Override
    public ResultModule<SearchResponse> scrollByQuery(String index, String type, QueryBuilder queryBuilder) {
        SearchResponse response = client.prepareSearch(index).setTypes(type)
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setQuery(queryBuilder)
                .setScroll(TimeValue.timeValueMillis(1000*60))
                .get();
        return ResultUtils.success(response);
    }

    @Override
    public ResultModule<SearchResponse> scrollAllReFields(String index, String type, String[] returnFields) {
        return scrollByQueryReFields(index,type,QueryBuilders.matchAllQuery(),returnFields);
    }

    @Override
    public ResultModule<SearchResponse> scrollByQueryReFields(String index, String type, QueryBuilder queryBuilder, String[] returnFields) {
        return scrollByQueryReFields(index,type,queryBuilder,returnFields,10);
    }

    @Override
    public ResultModule<SearchResponse> scrollByQueryReFields(String index, String type, QueryBuilder queryBuilder, String[] returnFields, int batchSize) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder).fetchSource(returnFields, null);//仅返回keywords字段
        searchSourceBuilder.size(batchSize);
        SearchResponse response = client.prepareSearch(index).setTypes(type)
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(TimeValue.timeValueMillis(1000*60))
                .setSource(searchSourceBuilder)
                .get();
        return ResultUtils.success(response);
    }

    @Override
    public ResultModule<SearchResponse> scrollByScrollId(String scrollId, long scrollTime) {
       SearchResponse response =  client.prepareSearchScroll(scrollId).setScroll(TimeValue.timeValueMillis(scrollTime)).get();
       return ResultUtils.success(response);
    }
}
