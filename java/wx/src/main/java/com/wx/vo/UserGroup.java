/*
 * Copyright (c) 2015.
 */

package com.wx.vo;

import java.util.List;

/**
 * Created by Jay on 2015/9/18.
 */
public class UserGroup {

    private int total;	            //��ע�ù����˺ŵ����û���
    private int count;              //��ȡ��OPENID���������ֵΪ10000
    private openid data;	        //�б����ݣ�OPENID���б�
    private String next_openid;     //��ȡ�б�����һ���û���OPENID

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public openid getData() {
        return data;
    }

    public void setData(openid data) {
        this.data = data;
    }



    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "total=" + total +
                ", count=" + count +
                ", data=" + data +
                ", next_openid='" + next_openid + '\'' +
                '}';
    }

    public UserGroup() {
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
