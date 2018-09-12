<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSH后台登录</title>
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css" />
</head>
<body>

	<div align='center'>
		<form id="loginForm" action="login" method="post">
			<table>
				<tr>
					<td>Mobile:</td>
					<td>
						<input class="easyui-textbox" type="text" id="mobile" name="username" data-options="validType:'mobile',required:true"/>
					</td>
				</tr>
				<br>
				<tr>
					<td>Password:</td>
					<td>
						<input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="onLogin();">登录</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
			
	<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript">
		function onLogin(){
			$('#loginForm').submit();
		}
	</script>
</body>
</html>