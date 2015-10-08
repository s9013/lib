package test.com.wx.util;

import com.wx.util.WxUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * WxUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>¾ÅÔÂ 17, 2015</pre>
 */
public class WxUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getToken()
     */
    @Test
    public void testGetToken() throws Exception {
        WxUtil.getToken();
    }


    /**
     * Method: getMenu()
     */
    @Test
    public void testGetMenu() throws Exception {
        WxUtil.getMenu();
    }




    @Test
    public void testGetUsers() throws Exception {
       System.out.print( WxUtil.getUsers(WxUtil.getToken().getAccessToken()));
    }

    @Test
    public void testGetUser() throws Exception {
       System.out.print( WxUtil.getUser(WxUtil.getToken().getAccessToken(), "o3DNit24WDaJj5Uc9_BJJFXz2Jec"));
    }
} 
