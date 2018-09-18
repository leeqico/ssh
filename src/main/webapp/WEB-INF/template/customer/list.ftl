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
		<a href="#" id="editButton" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
		<a href="#" id="removeButton" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a href="#" id="helpButton" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">帮助</a>
	</div>

	<table id="datagrid" class="easyui-datagrid" data-options="url:'load.jhtml',toolbar:'#tb',fitColumns:true,singleSelect:true">
		<thead>
			<tr>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'mobile'">手机号</th>
				<th data-options="field:'address'">地址</th>
				<th data-options="field:'remark'">备注</th>
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
		$('#editButton').click(onEdit);
		function onEdit(){
			var selectedRow = $('#datagrid').datagrid('getSelected');
			if(selectedRow){
				location.href = 'edit.jhtml?id=' + selectedRow.id;
			} else {
				$.messager.show({
					title:'提示',
					msg:'请选择一行',
					timeout:1000,
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
			}
		}
		$('#removeButton').click(onRemove);
		function onRemove(){
			var selectedRow = $('#datagrid').datagrid('getSelected');
			if(selectedRow){
				$.ajax({
					url: 'remove.jhtml',
					type: 'POST',
					cache: false,
					data: {id: selectedRow.id},
					dataType: "json",
					complete: function(){
						$('#datagrid').datagrid('reload');
					}
				});
			} else {
				$.messager.show({
					title:'提示',
					msg:'请选择一行',
					timeout:1000,
					showType:'show',
					style:{
						right:'',
						top:document.body.scrollTop+document.documentElement.scrollTop,
						bottom:''
					}
				});
			}
		}
	</script>
</body>
</html>
