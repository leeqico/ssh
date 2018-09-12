[#assign shiro = JspTaglibs["/WEB-INF/tags/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSH管理系统</title>
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css" />
</head>
<body>
	<body class="easyui-layout" id="layout" style="visibility:hidden;">
		[#-- 上 --]
	    <div data-options="region:'north',split:false,collapsible:false" style="height:60px;background:#99CCCC;overflow:hidden;border:none;">
	    	<div style="position:absolute;top:15px;left:50px;font-size:20px;">
	    		${userName}
	    	</div>
	    	<div style="text-align:center;line-height: 60px;font-size:20px;">
	    		SSH后台管理系统
	    	</div>
	    	<div style="position:absolute;top:15px;right:50px;font-size:20px;">
				<a href="logout" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-clear'">退出系统</a>
			</div>
	    </div>
	    [#-- 下 --]
	    <div data-options="region:'south',split:false" style="height:30px;">
	    	<div style="text-align:center;line-height: 30px;font-size:10px;">
	    		&copy;版权归属李庆超所有
	    	</div>
	    </div>
	    [#-- 左 --]
	    <div data-options="region:'west',split:true" style="width:200px;">
	    	<div class="easyui-accordion" id="navmenu" style="border:none;">
	    		<div title="订单管理">
	    			<ul>
						<li><a href="#" data-url="order/list">订单处理</a></li>
						<li><a href="#" data-url="receipt/list">订单收款</a></li>
					</ul>
	    		</div>
	    		<div title="库存管理">
	    			<ul>
						<li><a href="#" data-url="inStock/list">入库管理</a></li>
						<li><a href="#" data-url="outStock/list">出库管理</a></li>
						<li><a href="#" data-url="outStock/list">商品库存</a></li>
					</ul>
	    		</div>
	    		<div title="基本档案">
	    			<ul>
						<li><a href="#" data-url="user/list">用户档案</a></li>
						<li><a href="#" data-url="customer/list">客户档案</a></li>
						<li><a href="#" data-url="customer/list">商品档案</a></li>
					</ul>
	    		</div>
	    	</div>
	    </div>
	    [#-- 中 --]
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    	<div class="easyui-tabs" fit="true" id="centerTabs">
				<div title="首页" iconCls="icon-ok">
					<span>待处理</span>
				</div>
			</div>
	    </div>
	</body>
	
	<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js" ></script>
	<script type="text/javascript">
		$(function() {
			//添加新的Tab页
			$("#navmenu").on("click", "a[data-url]", function(e) {
				e.preventDefault();//取消事件的默认动作
				var tabTitle = $(this).text();
				var tabUrl = $(this).data("url");
				
				if($("#centerTabs").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
					$("#centerTabs").tabs("select", tabTitle);
				}else {
					var content="<iframe src='"+tabUrl+"' frameborder='0' scrolling='auto' style='width:100%;height:100%'>";
					$("#centerTabs").tabs("add", {
						title: tabTitle,
						//href: tabUrl,
						content:content,
						closable: true
					});
				}
			});
			
			//解决闪屏的问题
			window.setTimeout(function() {
				$("#layout").css("visibility", "visible");
			}, 800);
		});
	</script>
</body>
</html>