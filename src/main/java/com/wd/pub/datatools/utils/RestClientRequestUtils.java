package com.wd.pub.datatools.utils;

import com.xiaoleilu.hutool.io.IoUtil;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;
import com.xiaoleilu.hutool.lang.Console;
import com.xiaoleilu.hutool.util.ThreadUtil;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by DimonHo on 2018/1/8.
 */
@Component
public class RestClientRequestUtils {
    @Autowired
    private RestClient restClient;
    private static RestClientRequestUtils restClientRequestUtils;

    @PostConstruct
    public void init() {
        restClientRequestUtils = this;
    }

    public static JSONObject post(String url, String queryDsl, long sleepTime) {
        JSONObject resObj = null;
        try {
            HttpEntity entity = new NStringEntity(queryDsl, ContentType.APPLICATION_JSON);
            Response res = restClientRequestUtils.restClient.performRequest("POST", url, Collections.<String, String>emptyMap(), entity);
            String resString = IoUtil.read(res.getEntity().getContent(), "utf-8");
            resObj = JSONUtil.parseObj(resString);
        } catch (IOException e) {
            Console.error("scrollPost:" + e);
            ThreadUtil.sleep(sleepTime);
            sleepTime += 2000;
            resObj = post(url, queryDsl, sleepTime);
        }
        return resObj;
    }

    public static JSONObject get(String url, long sleepTime) {
        JSONObject resObj = null;
        try {
            Response res =restClientRequestUtils.restClient.performRequest("GET", url, Collections.<String, String>emptyMap());
            String resString = IoUtil.read(res.getEntity().getContent(), "utf-8");
            resObj = JSONUtil.parseObj(resString);
        } catch (IOException e) {
            Console.error("scrollPost:" + e);
            ThreadUtil.sleep(sleepTime);
            sleepTime += 2000;
            resObj = get(url, sleepTime);
        }
        return resObj;
    }
}
