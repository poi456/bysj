<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <script>
        if ("${error}"!=""){
            alert("${error}");
        }
    </script>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.1</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/lib/layui/layui.js" charset="utf-8"></script>
<%--    ./js/xadmin.js--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/cookie.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">邵阳阳光超市管理系统</div>
    <div id="darkbannerwrap"></div>

    <form action="<%=request.getContextPath()%>/account/main" method="post" class="layui-form" >
        <input name="uname" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>
</body>
</html>