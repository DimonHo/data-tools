package com.wd.pub.datatools.utils;

/**
 * Created by DimonHo on 2018/1/8.
 */
public class RestClientUrlUtils {
    private static String baseUri(String index,String type){
        return "/" + index + "/" + type;
    }

    public static String getDocByIdUrl(String index,String type,String id){
        return baseUri(index,type) + "/"+id;
    }
    public static String searchUrl(String index,String type){
        return baseUri(index,type) + "/_search";
    }

    public static String scrollSearchUrl(String index,String type,Long scrollTime){
        return baseUri(index,type) + "/_search?scroll=" + scrollTime + "ms";
    }

    public static String scrollSearchByScrollIdUrl(String scrollId,Long scrollTime){
        return "/_search/scroll?scroll=" + scrollTime + "ms&scroll_id=" + scrollId;
    }

}
