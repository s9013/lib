/*
 * Copyright (c) 2015.
 */

package com.wx.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jay on 2015/9/15.
 */

public class AccessToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    private int errcode = -1;

    private String errmsg;

    public AccessToken() {
    }

    public AccessToken(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }


    public String getAccessToken() {
        return accessToken;
    }


    public int getExpiresIn() {
        return expiresIn;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
