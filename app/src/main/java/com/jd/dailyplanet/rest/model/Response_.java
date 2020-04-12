
package com.jd.dailyplanet.rest.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Response_ {

  @Json(name = "status")
  private String status;
  @Json(name = "userTier")
  private String userTier;
  @Json(name = "total")
  private Integer total;
  @Json(name = "startIndex")
  private Integer startIndex;
  @Json(name = "pageSize")
  private Integer pageSize;
  @Json(name = "currentPage")
  private Integer currentPage;
  @Json(name = "pages")
  private Integer pages;
  @Json(name = "orderBy")
  private String orderBy;
  @Json(name = "results")
  private List<Result> results = null;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUserTier() {
    return userTier;
  }

  public void setUserTier(String userTier) {
    this.userTier = userTier;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getStartIndex() {
    return startIndex;
  }

  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }
}
