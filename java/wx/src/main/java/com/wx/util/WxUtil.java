package com.wx.util;

import com.google.gson.Gson;
import com.wx.vo.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

    // user
    private static String getUserListUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
    private static String getUserUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    // 认证
    private static final String getOauth2AccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    public static AccessToken getToken(){
        RestTemplate rest = new RestTemplate();
        String url = getTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
        AccessToken token = rest.postForObject(url, null, AccessToken.class);
        System.out.println(token);
        return token;
    }


    public static String getMenu(){
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
        return result;
    }

    public static String getMenu(String accessToken){
        RestTemplate rest = new RestTemplate();
        String url = findMenu.replace("ACCESS_TOKEN", accessToken);
        String result =  rest.postForObject(url, null, String.class);
        // 解决乱码问题
        try {
            result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }



    /****************** user start ****************************/
    public static UserGroupVo getUsers(String accessToken){
//        RestTemplate rest = new RestTemplate();
//        String url = getUserListUrl.replace("ACCESS_TOKEN",accessToken);
//        String result =  rest.getForObject(url, String.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//        //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
//        UserGroup vo = null;
//        try {
//             vo =  mapper.readValue(result, UserGroup.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<UserVo> userList = new ArrayList<UserVo>();
//        for (int i =0 ; i< vo.getData().getOpenid().size();i++){
//            userList.add(getUser(accessToken,vo.getData().getOpenid().get(i)));
//        }
//        vo.setUserList(userList);
//        return vo;


        RestTemplate rest = new RestTemplate();
        String url = getUserListUrl.replace("ACCESS_TOKEN",accessToken);
        UserGroup result =  rest.getForObject(url, UserGroup.class);

        UserGroupVo userGroupVo = new UserGroupVo();
        userGroupVo.setTotal(result.getTotal());

        List<UserVo> userList = new ArrayList<UserVo>();
        for (int i =0 ; i< result.getData().getOpenid().size();i++){
            userList.add(getUser(accessToken,result.getData().getOpenid().get(i)));
        }
        userGroupVo.setUserList(userList);
        return userGroupVo;

    }

    public static UserVo getUser(String accessToken,String openId){
        RestTemplate rest = new RestTemplate();
        String url =  getUserUrl.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openId);
        UserVo result = rest.getForObject(url,UserVo.class);
        return result;
    }
    /****************** user end ****************************/



    public static Oauth2Token getOauth2AccessToken(String appid,String appsecret,String code){
        RestTemplate rest = new RestTemplate();
        String url = getOauth2AccessTokenUrl.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
        String oauth2Token2 = rest.getForObject(url, String.class);
        System.out.println(oauth2Token2);

        Gson gson = new Gson();
        Oauth2Token oauth2Token = gson.fromJson(oauth2Token2,Oauth2Token.class);

        //Oauth2Token oauth2Token = rest.postForObject(url,null, Oauth2Token.class);
        return oauth2Token;


//        RestTemplate rest = new RestTemplate();
//        String url = getTokenUrl.replace("APPID",appId).replace("APPSECRET", appSecret);
//        AccessToken token = rest.postForObject(url, null, AccessToken.class);
//        System.out.println(token);
//        return token;

    }

}
