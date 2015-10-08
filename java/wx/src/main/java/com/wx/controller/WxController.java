package com.wx.controller;

import com.wx.util.MessageUtil;
import com.wx.util.TokenThread;
import com.wx.util.WxUtil;
import com.wx.vo.AccessToken;
import com.wx.vo.Oauth2Token;
import com.wx.vo.UserGroupVo;
import com.wx.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wx.util.CheckUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.System;
import java.util.Map;

/**
 * @author Jay
 */
@Controller
@RequestMapping("/wx")
public class WxController {

    @RequestMapping(value = "do",method = RequestMethod.GET)
    @ResponseBody
    public String doGet(HttpServletRequest request) throws  Exception{
        System.out.print("check signature");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            System.out.print("true");
            return echostr;
        }else{
            System.out.print("false");
            return "error";
        }
    }

    @RequestMapping(value = "do",method = RequestMethod.POST)
    @ResponseBody
    public String doPost(HttpServletRequest request)  throws  Exception{
        System.out.println("doPost");
        request.setCharacterEncoding("UTF-8");

        Map<String, String> map = MessageUtil.xmlToMap(request);

           // log.info(JSONObject.fromObject(map).toString());

            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String createTime = map.get("CreateTime");
            String msgType = map.get("MsgType");
            String content = map.get("Content");
            String msgId = map.get("MsgId");
            System.out.println(content);
            String message = null;

            String nickName = "";//WechatUtil.getUser( WechatUtil.getAccessToken().getAccessToken(), fromUserName).getString("nickname");

            String msg = nickName;

            if("text".equals(msgType)){
                if("hi".equals(content)){
                    msg +=  " hi";
                }else if("你好".equals(content)){
                    msg += " 你也好?";
                }else if(content.contains("公交卡")){
//                    String result = WeixinUtil.doGetStr2("http://220.248.75.36/handapp/PGcardAmtServlet?arg1="+ content.replaceAll("[^x00-xff]*", ""));
//                    result = result.substring(6,result.length()-3);
//                    msg += "公交卡余额" + result;
                }else if(content.contains("123")){
                    //msg += " 页面跳转 <a href='http://scorpioner.xicp.net/wechat/index.html?id="+ fromUserName
                    //		+" &token= "+ WechatUtil.getAccessToken().getAccessToken()+"&nickName="+  nickName +"'>跳转</a>" ;
                    System.out.println(msg);
                }else{
                    msg += "OMG!!!";
                   // log.info(msg);
                }
                message = MessageUtil.initText(toUserName, fromUserName, msg);
            }else if("event".equals(msgType) && map.get("Event").equals("CLICK")){

                msg += "hi！ <a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ TokenThread.APPID +"&redirect_uri=http://wind.ngrok.io/wx/oauth&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect'>click</a>";

                System.out.println(msg);

                message = MessageUtil.initText(toUserName, fromUserName, msg);

            }else if("location".equals(msgType)){// 地址
                msg += "您的地址是：" + map.get("Label");
                message = MessageUtil.initText(toUserName, fromUserName, msg);
            }

        return message;
    }

    /**
     * 获取token
     */
    @RequestMapping(value = "getToken",method = RequestMethod.GET)
    @ResponseBody
    public AccessToken getToken() throws  Exception{
       return TokenThread.accessToken;
    }

    /**
     * 获取菜单
     */
    @RequestMapping(value = "getMenu")
    @ResponseBody
    public String getMenu() throws  Exception{
        return WxUtil.getMenu(TokenThread.accessToken.getAccessToken());
    }

    /**
     *  获取用户
     */
    @RequestMapping(value = "getUsers")
    @ResponseBody
    public UserGroupVo getUsers() throws  Exception{
        return WxUtil.getUsers(TokenThread.accessToken.getAccessToken());
    }

    /**
     * oauth
     */
    @RequestMapping(value = "oauth")
    @ResponseBody
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (!"authdeny".equals(code)) {
            Oauth2Token oauth2Token = WxUtil.getOauth2AccessToken(TokenThread.APPID,TokenThread.APPSECRET,code);
            String openId = oauth2Token.getOpenid();
            UserVo userInfo = WxUtil.getUser(TokenThread.accessToken.getAccessToken(), openId);
            request.setAttribute("UserInfo", userInfo);
        }
        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
    }

}
