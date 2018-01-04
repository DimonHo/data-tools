package com.wd.pub.datatools.controller;

import com.wd.pub.datatools.service.ResolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DimonHo on 2018/1/4.
 */
@RestController
public class ResolveFileController {

    @Autowired
    ResolveService resolveWosToMongoService;

    @GetMapping("/resolve/wos")
    public String resolveWos(@RequestParam String directryPath){
        String wosmap = "static/resolveFileMap/wosmap.properties";
        return resolveWosToMongoService.excute(directryPath,wosmap);
    }
}
