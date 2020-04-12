
package com.jd.dailyplanet.rest.model;

import com.squareup.moshi.Json;


public class Response {

  @Json(name = "response")
  private Response_ response;

  public Response_ getResponse() {
    return response;
  }

  public void setResponse(Response_ response) {
    this.response = response;
  }

}
