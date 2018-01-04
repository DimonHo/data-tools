package com.wd.pub.datatools.service.impl;


import com.wd.pub.datatools.entity.mongo.Journal;
import com.wd.pub.datatools.entity.mongo.WosSource;
import com.wd.pub.datatools.repository.mongo.WosRepository;
import com.wd.pub.datatools.service.ResolveService;
import com.wd.pub.datatools.utils.CollectionUtils;
import com.wd.pub.datatools.utils.FileUtils;
import com.xiaoleilu.hutool.io.FileUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.xiaoleilu.hutool.util.ReflectUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * Created by DimonHo on 2017/12/22.
 * 解析wos文档到mongodb
 */
@Service("resolveWosToMongoService")
public class ResolveWosToMongoService implements ResolveService {

    private static final Logger logger = LoggerFactory.getLogger(ResolveWosToMongoService.class);

    @Autowired
    WosRepository wosRepository;
    private static Map<String,String> wosMap;
    private static List<WosSource> wosSourceList = new ArrayList<>();
    private static WosSource wosSource = new WosSource();
    private static Journal journalInfo = new Journal();
    private static String key = "";
    private static String value = "";
    //需要手动添加分隔符的字段
    private static List listField = CollectionUtil.newArrayList("references","authorsFull","authors","affiliationFull");

    public String excute(String directryPath,String mapPath){
        wosMap = this.getWosMap(mapPath);
        //获取目录以及子目录下的文件列表
        List<File> fileList = this.getFileList(directryPath);
        //遍历文件列表
        fileList.forEach(f -> resolve(f));
        return "ok";
    }

    /**
     * 按行读取单个文件
     * @param file
     */
    public void resolve(File file){
        List<String> lines = FileUtils.readBomLines(file);
        //过滤空行以及FN,VR,EF开头的行
        Predicate<String> notnull = (n) -> !StringUtils.isEmpty(n);
        Predicate<String> notStartFN = (n) -> !n.startsWith("FN");
        Predicate<String> notStartVR = (n) -> !n.startsWith("VR");
        Predicate<String> notStartEF = (n) -> !n.startsWith("EF");
        // 遍历文件所有行
        lines.stream().filter(notnull.and(notStartFN).and(notStartVR).and(notStartEF)).forEach(l -> resolveLine(l,file));
    }


    /**
     * 解析每行数据
     * @param line
     * @param file
     */
    public void resolveLine(String line,File file){
        //如果不为空格开始的行，表示开始一个新的字段
        if (!line.startsWith("   ")){
            if (!StrUtil.isEmpty(key) && !StrUtil.isEmpty(value)){
                if (key.startsWith("journalInfo.")){
                    ReflectUtil.setFieldValue(journalInfo,key.substring(12),value);
                }else if (ReflectUtil.getField(wosSource.getClass(),key).getType() == List.class){
                    ReflectUtil.setFieldValue(wosSource,key, CollectionUtils.newArrayList(value.split(";")));
                }else if (ReflectUtil.getField(wosSource.getClass(),key).getType() == int.class){
                    ReflectUtil.setFieldValue(wosSource,key,Integer.parseInt(value));
                }else{
                    ReflectUtil.setFieldValue(wosSource,key,value);
                }
            }
            //获取字段名称，对应WosSource字段名称
            key = wosMap.get(line.substring(0,2));
            if (!StringUtils.isEmpty(key)) {
                //如果遇到文件结束符
                if ("docEnd".equals(key)){
                    wosSource.setFileName(CollectionUtil.newArrayList(file.getName()));
                    wosSource.setSoulu(CollectionUtil.newArrayList(file.getParent().replaceAll(".*\\\\", "")));
                    wosSource.setUrl("http://dx.doi.org/"+ wosSource.getDoi());
                    wosSource.setJournalInfo(journalInfo);
                    wosSourceList.add(wosSource);
                    //每1000条写入一次数据库
                    if (wosSourceList.size() % 1000 == 0){
                        wosRepository.save(wosSourceList);
                        wosSourceList.clear();
                    }
                    //初始化document
                    wosSource = new WosSource();
                    journalInfo = new Journal();
                    key = "";
                    value = "";
                }else{ //不是文件的结束，则将第三个字符开始初始化value
                    value = line.substring(3);
                }
            }
        }else{
            if (!StringUtils.isEmpty(key)) {
                // 需要手动添加分隔符的字段
                if (listField.contains(key)){
                    value += (";"+line.substring(3));
                }else{
                    // 保留换行空格
                    value += line.substring(2);
                }
            }
        }
    }

    /**
     * 加载wos的map配置
     * @param mapPath
     * @return
     */
    public Map<String,String> getWosMap(String mapPath){
        List<String> lines = FileUtil.readLines(mapPath,"UTF-8");
        Map<String,String> map = new TreeMap<String,String>();
        //不为空的行
        Predicate<String> notnull = (n) -> !StringUtils.isEmpty(n);
        //不是 # 开头的行
        Predicate<String> startsWithFilter = (n) -> !n.trim().startsWith("#");
        // 执行过滤不为空 且 不是#号开头的行
        lines.stream().filter(notnull.and(startsWithFilter))
                //执行拆分
                .map(l -> l.split("="))
                //执行put到map中
                .forEach(s -> map.put(s[0],s[1]));
        return map;
    }

    public List<File> getFileList(String directryPath){
        return FileUtil.loopFiles(directryPath);
    }
}
