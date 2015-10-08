<%@page import="com.wx.vo.UserVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body>
个人基本信息

<%
    // 获取由OAuthServlet中传入的参数
    UserVo user = (UserVo) request.getAttribute("UserInfo");
    if (null != user) {
%>

<table width="100%" cellspacing="0" cellpadding="0" border="1" style="font-size: 40px">
    <tr>
        <td>头像</td>
        <td align="right"><img src="<%=user.getHeadimgurl()%>"
                               style="width: 100px; height: 100px;"/></td>
    </tr>
    <tr>
        <td>OpenID</td>
        <td align="right"><%=user.getOpenid()%>
        </td>
    </tr>
    <tr>
        <td>昵称</td>
        <td align="right"><%=user.getNickname()%>
        </td>
    </tr>
    <tr>
        <td>性别</td>
        <td align="right"><%=user.getSex()%>
        </td>
    </tr>
    <tr>
        <td>国家</td>
        <td align="right"><%=user.getCountry()%>
        </td>
    </tr>
    <tr>
        <td>省份</td>
        <td align="right"><%=user.getProvince()%>
        </td>
    </tr>
    <tr>
        <td>城市</td>
        <td align="right"><%=user.getCity()%>
        </td>
    </tr>
    <%-- 		<tr>
                <td>头像</td>
                <td><%=user.getHeadImgUrl()%></td>
            </tr> --%>
    <%-- 		<tr>
        <td>特权</td>
        <td><%=user.getPrivilegeList()%></td>
    </tr> --%>
</table>
<%
    } else
        out.print("用户不同意授权,未获取到用户信息！");
%>

</body>
</html>