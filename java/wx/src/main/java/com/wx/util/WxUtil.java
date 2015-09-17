package com.wx.util;

import org.springframework.web.client.RestTemplate;
import com.wx.vo.AccessToken;

import java.io.UnsupportedEncodingException;

/**
 * Created by Jay on 2015/9/17.
 */
public class WxUtil {

    private static String appId = "wx8dfda79a073efa18";
    private static String appSecret = "43b865a6d62dfdec8681ccaf9f804533";

    // url
    private static String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    // get menu
    private static String findMenu = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    public static AccessToken getToken(){
        RestTemplate rest = new RestTemplate();
        String url = getTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
        AccessToken token = rest.postForObject(url, null, AccessToken.class);
        System.out.println(token);
        return token;
    }


    public static void getMenu(){
        RestTemplate rest = new RestTemplate();
        String url = findMenu.replace("ACCESS_TOKEN", getToken().getAccessToken());
        String result =  rest.postForObject(url, null, String.class);
        // 解决乱码问题
        try {
            result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


}
