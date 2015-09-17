/*
 * Copyright (c) 2015.
 */

package com.wx.util;

import com.thoughtworks.xstream.XStream;
import com.wx.vo.TextMessageVo;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jay on 2015/9/17.
 */
public class MessageUtil {

    /**
     * xml 转为 map
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request)throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();

        org.dom4j.Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }

        ins.close();

        return map;
    }

    /**
     * 将文本消息对象转为xml
     * @return
     */
    public static String textMessageToXml(TextMessageVo textMessage){
        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }


    /**
     * 初始化文本消
     * @param toUserName
     * @param fromUserName
     * @param content
     * @return
     */
    public static String initText(String toUserName, String fromUserName,String content){
        TextMessageVo text = new TextMessageVo();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType("text");
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return MessageUtil.textMessageToXml(text);
    }

}
