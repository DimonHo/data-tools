package com.wd.pub.datatools.utils;

import com.xiaoleilu.hutool.util.CollectionUtil;

import java.util.ArrayList;

/**
 * Created by DimonHo on 2017/12/29.
 */
public class CollectionUtils extends CollectionUtil {

    /**
     * 字符串数组 转 字符串list
     * @param values
     * @return
     */
    public static ArrayList<String> newArrayList(String[] values) {
        if (null == values) {
            return new ArrayList();
        } else {
            ArrayList<String> arrayList = new ArrayList(values.length);
            for (String value:values){
                arrayList.add(value.trim());
            }
            return arrayList;
        }
    }
}
