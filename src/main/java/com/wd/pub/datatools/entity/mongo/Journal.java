package com.wd.pub.datatools.entity.mongo;

/**
 * Created by DimonHo on 2017/12/22.
 */
public class Journal {
    private String title;
    private String titleAbb;
    private String issn;
    private String eissn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleAbb() {
        return titleAbb;
    }

    public void setTitleAbb(String titleAbb) {
        this.titleAbb = titleAbb;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getEissn() {
        return eissn;
    }

    public void setEissn(String eissn) {
        this.eissn = eissn;
    }
}
