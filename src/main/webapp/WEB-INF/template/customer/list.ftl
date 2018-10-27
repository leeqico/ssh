<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户档案</title>
<link rel="stylesheet" type="text/css" href="/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/resources/easyui/themes/icon.css" />
</head>
<body class="easyui-layout">

	<div id="tb">
		<a href="#" id="addButton" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加(F1)</a>
		<a href="#" id="removeButton" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除(F2)</a>
		<a href="#" id="editButton" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改(F3)</a>
		<a href="#" id="viewButton" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查看(F4)</a>
		<a href="#" id="printButton" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">打印(F5)</a>
		<form id="form">
			<td>客户名称</td>
			<td>
				<input type="text" class="easyui-textbox" style="width:180px" id="name" name="name"/>
			</td>
			<td>
				<a href="#" id="searchButton" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="formSubmit();">搜索</a>
			</td>
		</form>
	</div>

	<table id="dataGrid" class="easyui-datagrid" data-options="url:'load.jhtml',toolbar:'#tb',singleSelect:true,rownumbers:true,pagination:true,pageSize:10,pageList:[10,20,30],pagePosition:'bottom',onDblClickRow:onDblClickRow" style="height:100%">
		<thead>
			<tr>
				<th data-options="field:'name',width:100">客户名称</th>
				<th data-options="field:'mobile',width:100">手机号</th>
				<th data-options="field:'address',width:200">地址</th>
				<th data-options="field:'userName',width:100,formatter:userFormatter">用户</th>
				<th data-options="field:'remark',width:150">备注</th>
			</tr>
	    </thead>
	</table>

	<script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript" src="/resources/js/list.js" ></script>
	<script type="text/javascript">
	
		$(function(){
			formSubmit();
		});
	
		//增加
		$('#addButton').click(onAdd);
		function onAdd(){
			location.href = 'add.jhtml';
		}
		
		//删除
		$('#removeButton').click(onRemove);
		function onRemove(){
			var selectedRow = $('#dataGrid').datagrid('getSelected');
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
									$('#dataGrid').datagrid('reload');
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
			var selectedRow = $('#dataGrid').datagrid('getSelected');
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
			var selectedRow = $('#dataGrid').datagrid('getSelected');
			if(selectedRow){
				location.href = 'view.jhtml?id=' + selectedRow.id;
			} else {
				$.messager.alert('提示','请先选中一行','info');
			}
		}
		
		//双击行查看
		function onDblClickRow(rowIndex,rowData){
			location.href = 'view.jhtml?id=' + rowData.id;
		}
		
		// 打印
		$('#printButton').click(onPrint);
		function onPrint(){
			var selectedRow = $('#dataGrid').datagrid('getSelected');
			if(selectedRow){
				window.open('print.jhtml?id='+selectedRow.id);
				$('#dataGrid').datagrid('reload');
			} else {
				$.messager.alert('提示','请先选中一行','info');
			}
		}
		
		//键盘按下事件
		$(document).keydown(function(event){
			var code = event.keyCode;
			if(code == 112){	//增加（F1）
				$('#addButton').trigger('click');
				return false;
			} else if(code == 113){	//删除（F2）
				$('#removeButton').trigger('click');
				return false;
			} else if(code == 114){	//修改（F3）
				$('#editButton').trigger('click');
				return false;
			} else if(code == 115){	//查看（F4）
				$('#viewButton').trigger('click');
				return false;
			} else if(code == 116){	//打印（F5）
				$('#printButton').trigger('click');
				return false;
			}
		});
		
		//用户格式化
		function userFormatter(value,row,index){
			if(row.user){
				return row.user.name;
			} else {
				return value;
			}
		}
		
	</script>
</body>
</html>
