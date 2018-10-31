<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/material-teal/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/demo/demo.css"/>
    <script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<div align='center'>
    <h2>注册</h2>
    <div class="easyui-panel" title="SSH管理系统" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="registerForm" action="register.jhtml" method="post">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="name" name="name" style="width:100%"
                       data-options="label:'Name:',iconCls:'icon-man',required:true,prompt:'请输入您的姓名'">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" id="mobile" name="mobile" style="width:100%"
                       data-options="label:'Mobile:',iconCls:'icon-man',validType:'mobile',required:true,prompt:'请输入您的手机号'">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" type="password" id="password" name="password" style="width:100%"
                       data-options="label:'Password:',iconCls:'icon-lock',required:true">
            </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="login.jhtml" class="easyui-linkbutton" data-options="iconCls:'icon-man'">已有账号，直接登录</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
               onclick="onRegister();">确认注册</a>
        </div>
    </div>
</div>


<script type="text/javascript" src="resources/easyui-extension/validatebox-extension.js"></script>
<script type="text/javascript">
    function onRegister() {
        if($.trim($('#name').val()).length >1 && $.trim($('#password').val()).length >1 && $.trim($('#name').val()).length >1) {
            $('#registerForm').submit();
        }
        return
    }
</script>
</body>
</html>