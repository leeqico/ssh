<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css" />
</head>
<body>

	<div align='center'>
		<h2>登录</h2>
		<form id="loginForm" action="login.jhtml" method="post">
			<table>
				<tr>
					<td>Mobile:</td>
					<td>
						<input class="easyui-textbox" type="text" id="mobile" name="mobile" value="18826230693" data-options="iconCls:'icon-man',validType:'mobile',required:true,prompt:'请输入您的手机号'"/>
					</td>
				</tr>
				<br>
				<tr>
					<td>Password:</td>
					<td>
						<input class="easyui-textbox" type="password" id="password" name="password" value="123456" data-options="iconCls:'icon-lock',required:true"/>
					</td>
				</tr>
				<tr>
					<td>
						<a href="register.jhtml" class="easyui-linkbutton" data-options="iconCls:'icon-man'">没有账号，我要注册</a>
					</td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="onLogin();">确认登录</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
			
	<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript" src="resources/easyui-extension/validatebox-extension.js" ></script>
	<script type="text/javascript">
		function onLogin(){
			$('#loginForm').submit();
		}
	</script>
</body>
</html>