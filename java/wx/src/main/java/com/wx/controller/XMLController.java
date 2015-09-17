package com.wx.controller;

import com.wx.vo.AccessToken;
import com.wx.vo.AccountBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jay
 */
@Controller
@RequestMapping("/api")
public class XMLController {


    @RequestMapping("/xml1")
    @ResponseBody
    public ModelAndView account() {
        System.out.println("#################ViewController doXMLJaxb2View##################");
        ModelAndView mav = new ModelAndView("jaxb2MarshallingView");
        AccountBean bean = new AccountBean();
        bean.setAddress("address");
        bean.setEmail("email");
        bean.setId(1);
        bean.setName("haha");
        mav.addObject(bean);
        return mav;
    }


    @RequestMapping("/token")
    @ResponseBody
    public ModelAndView token() {
        System.out.println("#################ViewController doXMLJaxb2View##################");
        ModelAndView mav = new ModelAndView("jaxb2MarshallingView");
        AccessToken token = new AccessToken();
        token.setAccessToken("adfadfadfasdfasd");
        token.setExpiresIn(7200);
        mav.addObject(token);
        return mav;
    }

}
