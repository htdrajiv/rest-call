package com.rn.code.service;

import com.google.gson.Gson;
import com.rn.code.model.Token;
import com.rn.code.model.TokenConf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rneup on 11/10/2017.
 */
class TokenService {
    private String PING_URL = "";
    private String CLIENT_ID = "";
    private String CLIENT_SECRET = "";

    TokenService(){}

    TokenService(String pingUrl, String clientId, String clientSecret){
        this.PING_URL = pingUrl;
        this.CLIENT_ID = clientId;
        this.CLIENT_SECRET = clientSecret;
    }

    private TokenConf authToken = null;

    private TokenConf getAuthToken(){
        RequestService request = new RequestService();
        String body = "client_id="+CLIENT_ID+"&client_secret="+CLIENT_SECRET;
        Map<String, String> requestParameters = new HashMap<String, String>(){{
            put("Content-Type", "application/x-www-form-urlencoded");
            put("Accept-Language", "en-US,en;q=0.5");
        }};
        try {
            Object object = request.sendPost(PING_URL,requestParameters,body);
            Gson gson = new Gson();
            Token token = gson.fromJson(object.toString(), Token.class);
            authToken = new TokenConf(token, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authToken;
    }

    TokenConf getToken(){
        if(authToken==null || tokenExpires(authToken)){
            authToken = getAuthToken();
        }
        return authToken;
    }

    private boolean tokenExpires(TokenConf token){
        if(authToken==null) return true;
        try {
            if(((new Date().getTime() - token.getTokenObtainedTime().getTime()) /1000) > Long.parseLong(token.getToken().getExpires_in())) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
