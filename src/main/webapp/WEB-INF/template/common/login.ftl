<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/demo/demo.css"/>
    <script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<div align='center'>
    <h2>登录</h2>
    <div class="easyui-panel" title="SSH管理系统" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="loginForm" action="login.jhtml" method="post">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="mobile" name="mobile" value="18826230693" style="width:100%"
                       data-options="label:'Mobile:',iconCls:'icon-man',validType:'mobile',required:true,prompt:'请输入您的手机号'">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" type="password" id="password" name="password" value="123456" style="width:100%"
                       data-options="label:'Password:',iconCls:'icon-lock',required:true">
            </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="register.jhtml" class="easyui-linkbutton" data-options="iconCls:'icon-man'">没有账号，我要注册</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="onLogin();">确认登录</a>
        </div>
    </div>

    <script type="text/javascript" src="resources/easyui-extension/validatebox-extension.js"></script>
    <script type="text/javascript">
        function onLogin() {
            $('#loginForm').submit();
        }
    </script>
</body>
</html>