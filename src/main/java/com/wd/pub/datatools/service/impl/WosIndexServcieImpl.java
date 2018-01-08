package com.wd.pub.datatools.service.impl;

import com.wd.pub.datatools.module.ResultModule;
import com.wd.pub.datatools.repository.elastic.ElasticRepository;
import com.wd.pub.datatools.repository.elastic.impl.RestClientRepository;
import com.wd.pub.datatools.repository.elastic.impl.TransportRepository;
import com.wd.pub.datatools.service.WosIndexServcie;
import com.wd.pub.datatools.utils.ResultUtils;
import com.xiaoleilu.hutool.json.JSONArray;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.lang.Console;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.ExistsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DimonHo on 2018/1/6.
 */
@Service("wosIndexServcie")
public class WosIndexServcieImpl implements WosIndexServcie {

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    RestClientRepository restClientRepository;

    private static final String INDEX = "wos_source3.0";
    private static final String TYPE = "periodical";

    private static final String INDEX11 = "wos_source";
    private static final String TYPE11 = "periodical";

    public ResultModule test(){
        ResultModule<JSONObject> resultModule = restClientRepository.scrollByQueryReFields(INDEX,TYPE, QueryBuilders.existsQuery("jguid"),new String[]{"jguid"});
        JSONObject jsonResp = resultModule.getData();
        do {
            BulkRequestBuilder bulkRequestBuilder = transportRepository.getClient().prepareBulk();
            JSONArray hits = jsonResp.getJSONObject("hits").getJSONArray("hits");
            for (int i=0;i<hits.size();i++){
                JSONObject jsonObject = (JSONObject) hits.get(i);
                String id = jsonObject.getStr("_id");
                JSONObject sourceMap = jsonObject.getJSONObject("_source");
                String jguid = sourceMap.getStr("jguid");
                Map<String ,Object> docMap = new HashMap<>();
                docMap.put("jguid",jguid);
                bulkRequestBuilder.add(transportRepository.getClient().prepareUpdate(INDEX11,TYPE11,id).setDoc(docMap));
                //transportRepository.updateFieldById(INDEX11,TYPE11,id,docMap);
            }
            bulkRequestBuilder.get();
            String srollId = jsonResp.getStr("_scroll_id");
            Console.log(srollId);
            jsonResp = restClientRepository.scrollByScrollId(srollId,1000*60*2).getData();
        }while (jsonResp.getJSONObject("hits").getJSONArray("hits").size()!=0);
        return ResultUtils.success();
    }



}
