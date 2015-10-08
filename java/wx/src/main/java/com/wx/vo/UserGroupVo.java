/*
 * Copyright (c) 2015.
 */

package com.wx.vo;

import java.util.List;

/**
 * Created by Jay on 2015/9/18.
 */
public class UserGroupVo {

    private int total;	            //关注该公众账号的总用户数
    private List<UserVo> userList;	//列表数据

    public UserGroupVo() {
    }

    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<UserVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserVo> userList) {
        this.userList = userList;
    }


    public static class openid{
        private List<String> openid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }

        public openid() {

        }

        public openid(List<String> openid) {
            this.openid = openid;
        }

        @Override
        public String toString() {
            return "openid{" +
                    "openid=" + openid +
                    '}';
        }
    }

}
