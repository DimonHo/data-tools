package com.wd.pub.datatools.controller;

import com.wd.pub.datatools.module.ResultModule;
import com.wd.pub.datatools.service.WosIndexServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DimonHo on 2018/1/6.
 */
@RestController
public class WosIndexController {

    @Autowired
    WosIndexServcie wosIndexServcie;

    @GetMapping("/wos/test")
    public ResultModule test(){
        return wosIndexServcie.test();
    }
}
