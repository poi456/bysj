<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
        <script>
            if ("${error}"!=""){
                alert('${error}')
            }


        </script>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
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
    <div class="x-body">
        <form action="<%=request.getContextPath()%>/account/add" class="layui-form">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>真实姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>将会成为您唯一的登入名
              </div>
          </div>

            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red"></span>用户账号
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="uname" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="password" required="" lay-verify="pass" value="111111"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    6到16个字符
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="repass" required="" lay-verify="repass" value="111111"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="Telephone" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input">
              </div>

          </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" lay-skin="primary" value="男" title="男">
                    <input type="radio" name="sex" lay-skin="primary" value="女" title="女">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">
                    <span class="x-red">*</span>邮箱
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_email" name="email" required="" lay-verify="email"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>职位</label>
                <div class="layui-input-block">
                    <input type="radio" name="level" lay-skin="primary" value="员工" title="员工">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red"></span>家庭住址
                </label>
                <div class="layui-input-inline">
                    <input type="text"  name="address" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <input type="submit" lay-filter="add" lay-submit="" class="layui-btn" value="增加">
            </div>
      </form>
    </div>
    <script>
        function formsubmit(data){
            console.log(data)
            <%--$.ajax({--%>
            <%--    url: "<%=request.getContextPath()%>/account/add",--%>
            <%--    data:data,--%>
            <%--    success: function(res){--%>
            <%--        console.log(res)--%>
            <%--    }--%>
            <%--});--%>
        }
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

            // layer.open
            // //监听提交
            // form.on('submit(add)', function(data) {
            //     console.log(data);
            //     //发异步，把数据提交给php
            //     layer.alert("增加成功", {
            //         icon: 6
            //     }, function() {
            //         // 获得frame索引
            //         var index = parent.layer.getFrameIndex(window.name);
            //         //关闭当前frame
            //         parent.layer.close(index);
            //         // 可以对父窗口进行刷新
            //         x_admin_father_reload();
            //     });
            //     return false;
            // });
            });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();

    </script>

  </body>

</html>