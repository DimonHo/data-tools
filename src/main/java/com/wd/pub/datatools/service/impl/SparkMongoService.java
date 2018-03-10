package com.wd.pub.datatools.service.impl;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DimonHo on 2018/1/8.
 */
public class SparkMongoService {
    @Autowired
    SparkSession sparkSession;

    public String test(){
        JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
        JavaMongoRDD<Document> rdd = MongoSpark.load(jsc);

        return null;
    }
}
