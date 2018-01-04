package com.wd.pub.datatools.entity.mongo;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by DimonHo on 2017/12/22.
 */
public class WosSource {
    @Id
    private String id;
    private Journal journalInfo;

    /** SN=issn */
    private String issn;

    /** EI=eissn */
    private String eissn;

    /** SO=journal */
    private String journal;

    /** J9=journalAbb */
    private String journalAbb;

    /** BN=isbn */
    private String isbn;

    /** D2=bookDoi */
    private String bookDoi;

    /** P2=chapterNum */
    private String chapterNum;

    /** Z9=cites */
    private int cites;

    /** TC=citesInwos */
    private int citesInwos;

    /** MA=conferenceAb */
    private String conferenceAb;

    /** CL=conferenceLocal */
    private String conferenceLocal;

    /** CY=conferenceDate */
    private String conferenceDate;

    /** HO=conferenceSponsor */
    private String conferenceSponsor;

    /** SP=conferenceSupport */
    private String conferenceSupport;

    /** CT=conferenceTitle */
    private String conferenceTitle;

    /** GA=deliveryNum */
    private String deliveryNum;

    /** AR=docNum */
    private String docNum;

    /** TI=docTitle */
    private String docTitle;

    /** DI=doi */
    private String doi;

    /** file.getName() */
    private List<String> fileName;

    /** file.getParent().replaceAll(".*\\\\", "") */
    private List<String> soulu;

    /** UT=utWos */
    private String utWos;

    /**  */
    private List<String> dbName;

    /** U1=halfCites */
    private int halfCites;

    /** JI=isoAbb */
    private String isoAbb;

    /** SI=issnueSpe */
    private String issnueSpe;

    /** IS=issue */
    private String issue;

    /** LA=language */
    private String language;

    /** new Date() */
    private Date lastUpdate = new Date();

    /** PN=pNomal */
    private String pNomal;

    /** PG=pageNum */
    private int pageNum;

    /**  */
    private String pageRange;

    /** BP=beforePage */
    private String beforePage;

    /** EP=endPage */
    private String endPage;

    /** PM=pmid */
    private String pmid;

    /** PT=pType */
    private String pType;

    /** PD=publishDate */
    private String publishDate;

    /** PU=publisher */
    private String publisher;

    /** PA=publisherAddress */
    private String publisherAddress;

    /** PI=publisherCity */
    private String publisherCity;

    /** NR=referencesNum */
    private int referencesNum;

    /** BS=seriesSubTitle */
    private String seriesSubTitle;

    /** SE=seriesTitle */
    private String seriesTitle;

    /** SU=suJournal */
    private String suJournal;

    /**  */
    private String url;

    /** U2=useNum */
    private int useNum;

    /** VL=volume */
    private String volume;

    /** PY=year */
    private int year;

    /** DT=docTypes */
    private List<String> docTypes;

    /** SC=sourceClassify */
    private List<String> sourceClassify;

    /** RP=reprintAuthor */
    private List<String> reprintAuthor;

    /** CR=references */
    private List<String> references;

    /** ID=keywordsPlus */
    private List<String> keywordsPlus;

    /** DE=keywords */
    private List<String> keywords;

    /** GP=groupAuthor */
    private List<String> groupAuthor;

    /** CA=countAuthor */
    private List<String> countAuthor;

    /** WC=classices */
    private List<String> classices;

    /** BE=bookEditor */
    private List<String> bookEditor;

    /** EM=email */
    private List<String> email;

    /** AU=authors */
    private List<String> authors;

    /** AF=authorsFull */
    private List<String> authorsFull;

    /** C1=affiliationFull */
    private List<String> affiliationFull;

    /** FU=fund */
    private String fund;

    /** FX=fundText */
    private String fundText;

    /** RI=rai */
    private List<String> rai;
    /** OI=oai */
    private List<String> oai;

    /** AB=abstractInfo */
    private String abstractInfo;

    /** BA=bookAuthor */
    private List<String> bookAuthors;

    /** BF=bookAuthorsFull */
    private List<String> bookAuthorsFull;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Journal getJournalInfo() {
        return journalInfo;
    }

    public void setJournalInfo(Journal journalInfo) {
        this.journalInfo = journalInfo;
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

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getJournalAbb() {
        return journalAbb;
    }

    public void setJournalAbb(String journalAbb) {
        this.journalAbb = journalAbb;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookDoi() {
        return bookDoi;
    }

    public void setBookDoi(String bookDoi) {
        this.bookDoi = bookDoi;
    }

    public String getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(String chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getCites() {
        return cites;
    }

    public void setCites(int cites) {
        this.cites = cites;
    }

    public int getCitesInwos() {
        return citesInwos;
    }

    public void setCitesInwos(int citesInwos) {
        this.citesInwos = citesInwos;
    }

    public String getConferenceAb() {
        return conferenceAb;
    }

    public void setConferenceAb(String conferenceAb) {
        this.conferenceAb = conferenceAb;
    }

    public String getConferenceLocal() {
        return conferenceLocal;
    }

    public void setConferenceLocal(String conferenceLocal) {
        this.conferenceLocal = conferenceLocal;
    }

    public String getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(String conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public String getConferenceSponsor() {
        return conferenceSponsor;
    }

    public void setConferenceSponsor(String conferenceSponsor) {
        this.conferenceSponsor = conferenceSponsor;
    }

    public String getConferenceSupport() {
        return conferenceSupport;
    }

    public void setConferenceSupport(String conferenceSupport) {
        this.conferenceSupport = conferenceSupport;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public List<String> getFileName() {
        return fileName;
    }

    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    public List<String> getSoulu() {
        return soulu;
    }

    public void setSoulu(List<String> soulu) {
        this.soulu = soulu;
    }

    public String getUtWos() {
        return utWos;
    }

    public void setUtWos(String utWos) {
        this.utWos = utWos;
    }

    public List<String> getDbName() {
        return dbName;
    }

    public void setDbName(List<String> dbName) {
        this.dbName = dbName;
    }

    public int getHalfCites() {
        return halfCites;
    }

    public void setHalfCites(int halfCites) {
        this.halfCites = halfCites;
    }

    public String getIsoAbb() {
        return isoAbb;
    }

    public void setIsoAbb(String isoAbb) {
        this.isoAbb = isoAbb;
    }

    public String getBeforePage() {
        return beforePage;
    }

    public void setBeforePage(String beforePage) {
        this.beforePage = beforePage;
    }

    public String getEndPage() {
        return endPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }

    public String getIssnueSpe() {
        return issnueSpe;
    }

    public void setIssnueSpe(String issnueSpe) {
        this.issnueSpe = issnueSpe;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getpNomal() {
        return pNomal;
    }

    public void setpNomal(String pNomal) {
        this.pNomal = pNomal;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageRange() {
        return pageRange;
    }

    public void setPageRange(String pageRange) {
        this.pageRange = pageRange;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public int getReferencesNum() {
        return referencesNum;
    }

    public void setReferencesNum(int referencesNum) {
        this.referencesNum = referencesNum;
    }

    public String getSeriesSubTitle() {
        return seriesSubTitle;
    }

    public void setSeriesSubTitle(String seriesSubTitle) {
        this.seriesSubTitle = seriesSubTitle;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getSuJournal() {
        return suJournal;
    }

    public void setSuJournal(String suJournal) {
        this.suJournal = suJournal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getDocTypes() {
        return docTypes;
    }

    public void setDocTypes(List<String> docTypes) {
        this.docTypes = docTypes;
    }

    public List<String> getSourceClassify() {
        return sourceClassify;
    }

    public void setSourceClassify(List<String> sourceClassify) {
        this.sourceClassify = sourceClassify;
    }

    public List<String> getReprintAuthor() {
        return reprintAuthor;
    }

    public void setReprintAuthor(List<String> reprintAuthor) {
        this.reprintAuthor = reprintAuthor;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public List<String> getKeywordsPlus() {
        return keywordsPlus;
    }

    public void setKeywordsPlus(List<String> keywordsPlus) {
        this.keywordsPlus = keywordsPlus;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getGroupAuthor() {
        return groupAuthor;
    }

    public void setGroupAuthor(List<String> groupAuthor) {
        this.groupAuthor = groupAuthor;
    }

    public List<String> getCountAuthor() {
        return countAuthor;
    }

    public void setCountAuthor(List<String> countAuthor) {
        this.countAuthor = countAuthor;
    }

    public List<String> getClassices() {
        return classices;
    }

    public void setClassices(List<String> classices) {
        this.classices = classices;
    }

    public List<String> getBookEditor() {
        return bookEditor;
    }

    public void setBookEditor(List<String> bookEditor) {
        this.bookEditor = bookEditor;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getAuthorsFull() {
        return authorsFull;
    }

    public void setAuthorsFull(List<String> authorsFull) {
        this.authorsFull = authorsFull;
    }

    public List<String> getAffiliationFull() {
        return affiliationFull;
    }

    public void setAffiliationFull(List<String> affiliationFull) {
        this.affiliationFull = affiliationFull;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getFundText() {
        return fundText;
    }

    public void setFundText(String fundText) {
        this.fundText = fundText;
    }

    public List<String> getRai() {
        return rai;
    }

    public void setRai(List<String> rai) {
        this.rai = rai;
    }

    public List<String> getOai() {
        return oai;
    }

    public void setOai(List<String> oai) {
        this.oai = oai;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public List<String> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<String> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public List<String> getBookAuthorsFull() {
        return bookAuthorsFull;
    }

    public void setBookAuthorsFull(List<String> bookAuthorsFull) {
        this.bookAuthorsFull = bookAuthorsFull;
    }
}
