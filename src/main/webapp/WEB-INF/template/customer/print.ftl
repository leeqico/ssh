<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户档案打印预览</title>
<link rel="stylesheet" type="text/css" href="/resources/css/print.css" />
</head>
<body style="margin-top: 10px;">

	<div class="print_button">
		<input id="btnPrint" type="button" value="打印" />
	</div>
	
	<div class="print">
		<div class="print_top">
			<div class="title">
				<span class="title_head">客户档案</span>
			</div>
		</div>
		<div class="print_middle">
			<table>
				<tr>
					<td style="width:10%;">客户名称：</td>
					<td style="width:10%;">${customer.name}</td>
					<td style="width:10%;">手机号：</td>
					<td style="width:10%;">${customer.mobile}</td>
				</tr>
				<tr>
					<td style="width:10%;">地址：</td>
					<td style="width:10%;">${customer.address}</td>
					<td style="width:10%;">用户：</td>
					<td style="width:10%;">${customer.user.name}</td>
				</tr>
				<tr>
					<td style="width:10%;">备注：</td>
					<td style="width:10%;">${customer.remark}</td>
				</tr>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.PrintArea.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#btnPrint').click(function(){
				$(".print").printArea();
			});
		});
	</script>
	
</body>
</html>
