<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户档案</title>
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/icon.css" />
</head>
<body>

	<div class="easyui-panel" data-options="fit:true">
		<div id="tb">
			<a href="#" id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存</a>
		</div>
		<div>
			<form id="detailForm" method="post" action="save.jhtml">
				<table>
					<td>姓名</td>
					<td>
						<input type="text" class="easyui-textbox" name="name" value="" data-options="required:true"/>
					</td>
				</table>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="/ssh/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript">
		$('#saveButton').click(onSave);
		function onSave(){
			$("#detailForm").submit();
		}
	</script>
</body>
</html>
