/*
 * Copyright (c) 2015.
 */

package com.wx.controller;

import com.wx.util.TokenThread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Jay on 2015/9/17.
 */
public class InitServlet extends HttpServlet{

    private static final long serialVersionUID = -6319898826127265611L;

    public void init() throws ServletException {

        TokenThread.APPID = getInitParameter("APPID");
        TokenThread.APPSECRET = getInitParameter("APPSECRET");

       // log.info("appid:" + TokenThread.APPID);
        System.out.print("appid:" + TokenThread.APPID);
        System.out.print("appsecret:" + TokenThread.APPSECRET);

       // log.info("appsecret:" + TokenThread.APPSECRET);

        // start token thread
        new Thread(new TokenThread()).start();

    }


}
