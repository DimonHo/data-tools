package com.wd.pub.datatools.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by DimonHo on 2018/1/8.
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "spark.mongo.session")
public class SparkMongoConfig {

    private String master;
    private String appName;
    private String inputUri;
    private String outputUri;

    private SparkSession sparkSession;

    @Bean
    public SparkSession getSparkSession(){
        return builder();
    }

    private SparkSession builder(){
        sparkSession = SparkSession.builder()
                .master(master)
                .appName(appName)
                .config("spark.mongodb.input.uri", inputUri)
                .config("spark.mongodb.output.uri", outputUri)
                .getOrCreate();
        return sparkSession;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getInputUri() {
        return inputUri;
    }

    public void setInputUri(String inputUri) {
        this.inputUri = inputUri;
    }

    public String getOutputUri() {
        return outputUri;
    }

    public void setOutputUri(String outputUri) {
        this.outputUri = outputUri;
    }
}
