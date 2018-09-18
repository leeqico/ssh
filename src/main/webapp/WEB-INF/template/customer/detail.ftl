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
			<a href="#" id="backButton" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true">返回</a>
			<a href="#" id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存</a>
		</div>
		<div>
			<form id="detailForm" method="post" action="[#if operation == 'add']save.jhtml[#else]update.jhtml[/#if]">
				<input type="hidden" id="id" name="id" value="${customer.id}" />
				<table>
					<tr>
						<td>姓名</td>
						<td>
							<input type="text" class="easyui-textbox" name="name" value="${customer.name}" data-options="required:true"/>
						</td>
						<td>手机号</td>
						<td>
							<input type="text" class="easyui-textbox" name="mobile" value="${customer.mobile}"/>
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
	<script type="text/javascript">
		$('#saveButton').click(onSave);
		function onSave(){
			$("#detailForm").submit();
		}
		$('#backButton').click(onBack);
		function onBack(){
			location.href = 'list.jhtml';
		}
	</script>
</body>
</html>