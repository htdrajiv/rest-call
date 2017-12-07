package com.rn.code.model;

import java.util.Map;

/**
 * Created by rneup on 11/29/2017.
 */
public class RequestParams {
    private String type;
    private String pingUrl;
    private String clientId;
    private String clientSecret;
    private String url;
    private Object body;
    private Map<String,String> headerParameters;

    public RequestParams(String url, Object body, Map<String, String> headerParameters) {
        this.url = url;
        this.body = body;
        this.headerParameters = headerParameters;
        this.type = "POST";
    }

    public RequestParams(String url, Map<String, String> headerParameters) {
        this.url = url;
        this.headerParameters = headerParameters;
        this.type = "GET";
    }

    public RequestParams(String url, Object body, Map<String, String> headerParameters, String pingUrl, String clientId, String clientSecret) {
        this.url = url;
        this.body = body;
        this.headerParameters = headerParameters;
        this.pingUrl = pingUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.type = "POST";
    }

    public RequestParams(String url, Map<String, String> headerParameters, String pingUrl, String clientId, String clientSecret) {
        this.url = url;
        this.headerParameters = headerParameters;
        this.pingUrl = pingUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.type = "GET";
    }

    public RequestParams(String pingUrl, String clientId, String clientSecret) {
        this.pingUrl = pingUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.type = "GET";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Map<String, String> getHeaderParameters() {
        return headerParameters;
    }

    public void setHeaderParameters(Map<String, String> headerParameters) {
        this.headerParameters = headerParameters;
    }

    public String getPingUrl() {
        return pingUrl;
    }

    public void setPingUrl(String pingUrl) {
        this.pingUrl = pingUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
