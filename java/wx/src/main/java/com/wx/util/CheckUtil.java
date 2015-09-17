package com.wx.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Jay on 2015/9/17.
 */
public class CheckUtil {

    // public static final String token = "9gyN-I7tGE9Zr4kFycXozWyN5uoQ9J9N8UCwpaKTxxsLNynGKa7s9XVNu_IRgvwCEJFi5CpY3ZtEt3wNxM71bBCjYpfAIordP5nrVAeo9NE";

    public static boolean checkSignature(String signature, String timestamp,String nonce) {

        String token = TokenThread.accessToken.getAccessToken();
        //System.out.println("------------token------------ " + token);
        String[] arr = new String[] { token, timestamp, nonce };

        // ÅÅÐò
        Arrays.sort(arr);

        // Éú³É×Ö·û
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        // sha1 ¼ÓÃÜ
        String str = Encrypt(sb.toString(), "SHA-1") ;
        System.out.println(str);
        return signature.equals(str);

    }


    public static String Encrypt(String strSrc, String encName) {
        // parameter strSrc is a string will be encrypted,
        // parameter encName is the algorithm name will be used.
        // encName dafault to "MD5"
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "MD5";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (Exception e) {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

}
