package com.sap.spring.mongodb.modal;

public class Response {
  private String response;
  private String responseMessage;

  public Response() {
  }

  public Response(String response, String responseMessage) {
    this.response = response;
    this.responseMessage = responseMessage;
  }

  public String getResponse() {
    return response;
  }

  public Response setResponse(String response) {
    this.response = response;
    return this;
  }

  public String getResponseMessage() {
    return responseMessage;
  }

  public Response setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
    return this;
  }

  @Override
  public String toString() {
    return "Response{" +
            "response='" + response + '\'' +
            ", responseMessage='" + responseMessage + '\'' +
            '}';
  }
}
