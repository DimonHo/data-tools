package com.wd.pub.datatools.repository.mysql.primary;

import com.wd.pub.datatools.entity.mysql.primary.Jinformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DimonHo on 2018/1/4.
 */
public interface JinformationRepository extends JpaRepository<Jinformation,Long>{

    List<Jinformation> findByStatusIsNotNull();
}
