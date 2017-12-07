package com.rn.code.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rn.code.model.RequestParams;
import com.rn.code.model.TokenConf;

import java.util.Map;

/**
 * Created by rneup on 11/10/2017.
 */
public class RestService {
    private com.rn.code.model.RequestParams RequestParams;
    private TokenService tokenService;
    private RequestService requestService = new RequestService();


    public com.rn.code.model.RequestParams getRequestParams() {
        return RequestParams;
    }
    /*
    *  for POST request
    * */
    public RestService(String url, Object body, Map<String,String> headerParameters){
        this.RequestParams = new RequestParams(url,body,headerParameters);
    }
    /*
    * for GET request
    * */
    public RestService(String url,Map<String,String> headerParameters){
        this.RequestParams = new RequestParams(url,headerParameters);
    }
    /*
    * for POST request with token credentials
    * */
    public RestService(String url, Object body, Map<String,String> headerParameters, String pingUrl, String clientId, String clientSecret){
        this.RequestParams = new RequestParams(url,body,headerParameters,pingUrl,clientId,clientSecret);
    }
    /*
    * for easy configuration with bean creation.
    * */
    public RestService(String pingUrl, String clientId, String clientSecret){
        this.RequestParams = new RequestParams(pingUrl,clientId,clientSecret);
    }
    /*
     * for GET request with token credentials
     * */
    public RestService(String url, Map<String,String> headerParameters, String pingUrl, String clientId, String clientSecret){
        this.RequestParams = new RequestParams(url,headerParameters,pingUrl,clientId,clientSecret);
    }

    public Object makeRequest(){
        com.rn.code.model.RequestParams requestParams = this.RequestParams;
        if(tokenService==null){
            if(requestParams.getPingUrl()!=null && requestParams.getClientId()!=null && requestParams.getClientSecret()!=null)
                tokenService = new TokenService(requestParams.getPingUrl(),requestParams.getClientId(),requestParams.getClientSecret());
            else
                tokenService = new TokenService();
        }
        TokenConf tokenConf = tokenService.getToken();
        attachTokenToHeader(tokenConf.getToken().getToken_type(), tokenConf.getToken().getAccess_token());
        Object result = null;
        try {
            if(requestParams.getType().equalsIgnoreCase("get"))
                result = requestService.sendGet(requestParams.getUrl(), requestParams.getHeaderParameters());
            else
                result = requestService.sendPost(requestParams.getUrl(), requestParams.getHeaderParameters(), requestParams.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(result!=null ? result.toString() : "{}", JsonObject.class);
    }

    private void attachTokenToHeader(String type,String token){
        Map<String,String> headerParams = this.RequestParams.getHeaderParameters();
        headerParams.put("Authorization",type+" "+token);
        this.RequestParams.setHeaderParameters(headerParams);
    }
}
