package com.wd.pub.datatools.utils;

import com.xiaoleilu.hutool.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by DimonHo on 2017/12/27.
 */
public class FileUtils extends FileUtil {

    /**
     * 按行读取文件全部内容
     * @param file
     * @return 注意文件首行第一个字符实际上会有一个空字符，表示文件BOM。
     */
    public static ArrayList<String> readBomLines(File file){
        ArrayList<String> lines = new ArrayList<String>();
        try {
            //FileReader reader = new FileReader(file); //会有首行bom字符问题存在，改用下面的方法，可避免首行第一个bom字符问题。
            UnicodeReader r = new UnicodeReader(new FileInputStream(file), null);
            BufferedReader bufferedReader = new BufferedReader(r);
            String str = null;
            while((str = bufferedReader.readLine()) != null) {
                lines.add(str);
            }
            bufferedReader.close();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
