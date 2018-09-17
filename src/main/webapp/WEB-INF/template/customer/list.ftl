<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户档案</title>
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/icon.css" />
</head>
<body>

	<div id="tb">
		<a href="#" id="addButton" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
		<a href="#" id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
		<a href="#" id="helpButton" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">帮助</a>
	</div>

	<table class="easyui-datagrid" data-options="url:'load.jhtml',toolbar:'#tb',fitColumns:true,singleSelect:true">
		<thead>
			<tr>
				<th data-options="field:'name'">Name</th>
				<th data-options="field:'mobile'">Mobile</th>
			</tr>
	    </thead>
	</table>

	<script type="text/javascript" src="/ssh/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript">
		$('#addButton').click(onAdd);
		function onAdd(){
			location.href = 'add.jhtml';
		}
	</script>
</body>
</html>
