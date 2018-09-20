<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户档案</title>
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/ssh/resources/easyui/themes/icon.css" />
</head>
<body class="easyui-layout">

	<div id="tb">
		<a href="#" id="addButton" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
		<a href="#" id="removeButton" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a href="#" id="editButton" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a href="#" id="viewButton" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查看</a>
	</div>

	<table id="datagrid" class="easyui-datagrid" data-options="url:'load.jhtml',toolbar:'#tb',singleSelect:true,rownumbers:true,pagination:true,pageSize:10,pageList:[10,20,30],pagePosition:'bottom',showFooter:true,onDblClickRow:onDblClickRow" style="height:100%">
		<thead>
			<tr>
				<th data-options="field:'name',width:100">客户名称</th>
				<th data-options="field:'mobile',width:100">手机号</th>
				<th data-options="field:'address',width:200">地址</th>
				<th data-options="field:'remark',width:150">备注</th>
			</tr>
	    </thead>
	</table>

	<script type="text/javascript" src="/ssh/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript">
	
		//增加
		$('#addButton').click(onAdd);
		function onAdd(){
			location.href = 'add.jhtml';
		}
		
		//删除
		$('#removeButton').click(onRemove);
		function onRemove(){
			var selectedRow = $('#datagrid').datagrid('getSelected');
			if(selectedRow){
				$.messager.confirm({
					title: '提示',
					msg: '确认删除？',
					fn: function(r){
						if (r){
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
						}
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
		
		//修改
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
		
		//查看
		$('#viewButton').click(onView);
		function onView(){
			var selectedRow = $('#datagrid').datagrid('getSelected');
			if(selectedRow){
				location.href = 'view.jhtml?id=' + selectedRow.id;
			} else {
				$.messager.alert('提示','请先选中一行','info');
			}
		}
		
		function onDblClickRow(rowIndex,rowData){
			location.href = 'view.jhtml?id=' + rowData.id;
		}
	</script>
</body>
</html>
