package com.wd.pub.datatools.controller;

import com.wd.pub.datatools.service.JournalIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DimonHo on 2018/1/4.
 */
@RestController
public class JournalIndexController {

    @Autowired
    JournalIndexService journalIndexService;

    @GetMapping("/journal/addStatus")
    public String addJournalStatus(){
        return journalIndexService.updateJournalIndexStatus();
    }
}
