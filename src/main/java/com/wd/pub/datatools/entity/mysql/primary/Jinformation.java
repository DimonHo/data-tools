package com.wd.pub.datatools.entity.mysql.primary;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JInformation")
public class Jinformation {
  @Id
  private Long id;
  private String director;
  private String description;
  private String publisher;
  private String country;
  private String postcode;
  private Long year;
  private String logo;
  private Long isoa;
  private String note;
  private String jguid;
  private String email;
  private String telephone;
  private String publishcycle;
  private String language;
  private String address;
  private String searcharea;
  private String creator;
  private String source;
  private String history;
  private String status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public Long getIsoa() {
    return isoa;
  }

  public void setIsoa(Long isoa) {
    this.isoa = isoa;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getJguid() {
    return jguid;
  }

  public void setJguid(String jguid) {
    this.jguid = jguid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getPublishcycle() {
    return publishcycle;
  }

  public void setPublishcycle(String publishcycle) {
    this.publishcycle = publishcycle;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSearcharea() {
    return searcharea;
  }

  public void setSearcharea(String searcharea) {
    this.searcharea = searcharea;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history = history;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
