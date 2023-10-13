package com.jsgk.retrofit;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class usermodal implements Serializable {
  private Integer per_page;

  private Integer total;

  private List<Data> data;

  private Integer page;

  private Integer total_pages;

  private Support support;

  public Integer getPer_page() {
    return this.per_page;
  }

  public void setPer_page(Integer per_page) {
    this.per_page = per_page;
  }

  public Integer getTotal() {
    return this.total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<Data> getData() {
    return this.data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  public Integer getPage() {
    return this.page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotal_pages() {
    return this.total_pages;
  }

  public void setTotal_pages(Integer total_pages) {
    this.total_pages = total_pages;
  }

  public Support getSupport() {
    return this.support;
  }

  public void setSupport(Support support) {
    this.support = support;
  }

  public static class Data implements Serializable {
    private String last_name;

    private Integer id;

    private String avatar;

    private String first_name;

    private String email;

    public String getLast_name() {
      return this.last_name;
    }

    public void setLast_name(String last_name) {
      this.last_name = last_name;
    }

    public Integer getId() {
      return this.id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getAvatar() {
      return this.avatar;
    }

    public void setAvatar(String avatar) {
      this.avatar = avatar;
    }

    public String getFirst_name() {
      return this.first_name;
    }

    public void setFirst_name(String first_name) {
      this.first_name = first_name;
    }

    public String getEmail() {
      return this.email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
  }

  public static class Support implements Serializable {
    private String text;

    private String url;

    public String getText() {
      return this.text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getUrl() {
      return this.url;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }
}
