package com.wd.pub.datatools.module;

/**
 * Created by DimonHo on 2018/1/4.
 */
public class ElasticFeildModule {

    private String fieldName;
    private Object fieldValue;

    public String getFieldName() {
        return fieldName;
    }

    public ElasticFeildModule fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public ElasticFeildModule fieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
        return this;
    }
}
