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
			<a href="#" id="backButton" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true">返回(ESC)</a>
			[#if operation == 'add' || operation == 'edit']
			<a href="#" id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存(F5)</a>
			[/#if]
		</div>
		<div>
			<form id="detailForm" method="post" action="[#if operation == 'add']save.jhtml[#else]update.jhtml[/#if]">
				<input type="hidden" id="id" name="id" value="${customer.id}" />
				<table>
					<tr>
						<td>客户名称</td>
						<td>
							<input type="text" class="easyui-textbox" name="name" value="${customer.name}" data-options="required:true"/>
						</td>
						<td>手机号</td>
						<td>
							<input type="text" class="easyui-textbox" name="mobile" value="${customer.mobile}" data-options="validType:'mobile'"/>
						</td>
					</tr>
					<tr>
						<td>地址</td>
						<td>
							<input type="text" class="easyui-textbox" name="address" value="${customer.address}"/>
						</td>
						<td>备注</td>
						<td>
							<input type="text" class="easyui-textbox" name="remark" value="${customer.remark}"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="/ssh/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/ssh/resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript" src="/ssh/resources/easyui-extension/validatebox-extension.js" ></script>
	<script type="text/javascript">
	
		$(function(){
			[#if operation == 'view']
				$('.easyui-textbox').textbox('disable',true);
			[/#if]
		});
		
		//保存
		$('#saveButton').click(onSave);
		function onSave(){
			$("#detailForm").submit();
		}
		
		//返回
		$('#backButton').click(onBack);
		function onBack(){
			location.href = 'list.jhtml';
		}
		
		//键盘按下事件
		$(document).keydown(function(event){
			event.preventDefault(); //阻止浏览器的默认事件
			switch(event.keyCode){
				case 27:	//返回（ESC）
					$('#backButton').trigger('click');
					break;
				case 116:	//保存（F5）
					$('#saveButton').trigger('click');
					break;
			}
		});
	</script>
</body>
</html>
