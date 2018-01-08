package com.wd.pub.datatools.utils;

import com.wd.pub.datatools.module.ResultModule;

/**
 * Created by DimonHo on 2018/1/5.
 */
public class ResultUtils {

    public static <T> ResultModule success(T object) {
        ResultModule<T> result = new ResultModule<T>();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }


    public static ResultModule success() {
        return success(null);
    }


    public static ResultModule error(int code, String msg) {
        ResultModule result = new ResultModule();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
