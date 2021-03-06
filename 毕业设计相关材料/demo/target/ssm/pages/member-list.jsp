<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html class="x-admin-sm">
<head>
  <meta charset="UTF-8">
  <title>欢迎页面-X-admin2.1</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/xadmin.css">
  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/lib/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/xadmin.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/cookie.js"></script>
  <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
  <!--[if lt IE 9]>
  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
  <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
    <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
  <div class="layui-row">
    <form class="layui-form layui-col-md12 x-so" action="<%=request.getContextPath()%>/account/FuzzyQuery">
      <input type="text" name="FuzzyQuery"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
    <input type="submit" class="layui-btn"  lay-submit="" lay-filter="sreach"  >
    </form>
  </div>
  <xblock>
     <button class="layui-btn" onclick="x_admin_show('添加员工','<%=request.getContextPath()%>/pages/admin-add.jsp',600,400)"><i class="layui-icon"></i>添加</button>
  </xblock>
  <table class="layui-table x-admin">
    <thead>
    <tr>
      <th>
        <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
      </th>
      <th>用户名</th>
      <th>性别</th>
      <th>手机</th>
      <th>邮箱</th>
      <th>地址</th>
      <th>级别</th>
      <th>密码</th>
      <th>账号</th>
      <th>操作</th></tr>
    </thead>
    <tbody>

      <c:forEach items="${findAll}" var="account">
        <tr>
          <td>
            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
          </td>
        <td>${account.username}</td>
        <td>${account.sex}</td>
        <td>${account.telephone}</td>
        <td>${account.email}</td>
        <td>${account.address}</td>
        <td>${account.level}</td>
          <td>${account.password}</td>
          <td>${account.uname}</td>
      <td class="td-manage">

        <a title="编辑"  onclick="x_admin_show('编辑','member-edit.html',600,400)" href="javascript:;">
          <i class="layui-icon">&#xe642;</i>
        </a>
        <a onclick="x_admin_show('修改密码','member-password.jsp',600,400)" title="修改密码"
           href="<%=request.getContextPath()%>/pages/member-password.jsp?username=${account.username}&uname=${account.uname}">
          <i class="layui-icon">&#xe631;</i>
        </a>
<%--        onclick="member_del(this,'要删除的id')"--%>
        <a title="删除"  href="<%=request.getContextPath()%>/account/delete/?uname=${account.uname}">
          <i class="layui-icon">&#xe640;</i>
        </a>
      </td>
    </tr>
      </c:forEach>

    </tbody>
  </table>

</div>
<script>
  layui.use('laydate', function(){
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
      elem: '#start' //指定元素
    });

    //执行一个laydate实例
    laydate.render({
      elem: '#end' //指定元素
    });
  });

  /*用户-停用*/
  function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){

      if($(obj).attr('title')=='启用'){

        //发异步把用户状态进行更改
        $(obj).attr('title','停用')
        $(obj).find('i').html('&#xe62f;');

        $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
        layer.msg('已停用!',{icon: 5,time:1000});

      }else{
        $(obj).attr('title','启用')
        $(obj).find('i').html('&#xe601;');

        $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
        layer.msg('已启用!',{icon: 5,time:1000});
      }

    });
  }

  /*用户-删除*/
  function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
      //发异步删除数据
      $(obj).parents("tr").remove();
      layer.msg('已删除!',{icon:1,time:1000});
    });
  }



  function delAll (argument) {

    var data = tableCheck.getData();

    layer.confirm('确认要删除吗？'+data,function(index){
      //捉到所有被选中的，发异步进行删除
      layer.msg('删除成功', {icon: 1});
      $(".layui-form-checked").not('.header').parents('tr').remove();
    });
  }
</script>
<script>var _hmt = _hmt || []; (function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>