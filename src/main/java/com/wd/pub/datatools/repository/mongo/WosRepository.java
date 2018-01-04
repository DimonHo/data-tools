package com.wd.pub.datatools.repository.mongo;

import com.wd.pub.datatools.entity.mongo.WosSource;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by DimonHo on 2017/12/29.
 */
public interface WosRepository extends MongoRepository<WosSource,String>{

}
