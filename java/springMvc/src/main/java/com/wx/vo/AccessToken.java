package com.wx.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jay on 2015/9/15.
 */
@XmlRootElement(name = "accessToken")
public class AccessToken {


    private String accessToken;

    private int expiresIn;

    public AccessToken() {
    }

    public AccessToken(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    @XmlElement
    public String getAccessToken() {
        return accessToken;
    }

    @XmlElement
    public int getExpiresIn() {
        return expiresIn;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
