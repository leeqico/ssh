<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css" />
</head>
<body>

	<div align='center'>
		<h2>注册</h2>
		<form id="registerForm" action="register.jhtml" method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td>
						<input class="easyui-textbox" type="text" id="name" name="name" data-options="iconCls:'icon-man',required:true,prompt:'请输入您的姓名'"/>
					</td>
				</tr>
				<tr>
					<td>Mobile:</td>
					<td>
						<input class="easyui-textbox" type="text" id="mobile" name="mobile" data-options="iconCls:'icon-man',validType:'mobile',required:true,prompt:'请输入您的手机号'"/>
					</td>
				</tr>
				<br>
				<tr>
					<td>Password:</td>
					<td>
						<input class="easyui-textbox" type="password" id="password" name="password" data-options="iconCls:'icon-lock',required:true"/>
					</td>
				</tr>
				<tr>
					<td>
						<a href="login.jhtml" class="easyui-linkbutton" data-options="iconCls:'icon-man'">已有账号，直接登录</a>
					</td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="onRegister();">确认注册</a>
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
		function onRegister(){
			$('#registerForm').submit();
		}
	</script>
</body>
</html>