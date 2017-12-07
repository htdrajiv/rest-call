package com.rn.code.model;

import java.util.Date;

/**
 * Created by rneup on 11/10/2017.
 */
public class TokenConf {
    private Token token;
    private Date tokenObtainedTime;

    public TokenConf(Token token, Date obtainedTime){
        this.token = token;
        this.tokenObtainedTime = obtainedTime;
    }

    public Date getTokenObtainedTime() {
        return tokenObtainedTime;
    }

    public void setTokenObtainedTime(Date tokenObtainedTime) {
        this.tokenObtainedTime = tokenObtainedTime;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
