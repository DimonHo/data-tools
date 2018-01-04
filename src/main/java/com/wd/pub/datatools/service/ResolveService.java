package com.wd.pub.datatools.service;

import com.xiaoleilu.hutool.io.FileUtil;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * Created by DimonHo on 2017/12/28.
 */
public interface ResolveService {

    public String excute(String directryPath,String mapPath);

}
