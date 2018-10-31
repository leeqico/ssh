[#assign shiro = JspTaglibs["/WEB-INF/tags/shiro.tld"] /]
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSH管理系统</title>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/material-teal/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="resources/easyui/demo/demo.css"/>
    <script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="resources/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script>
        var data = [{
            text: '订单管理',
            iconCls: 'icon-more',
            state: 'open',
            children: [{
                text: '订单处理',
                url: 'order/list.jhtml'
            },{
                text: '订单收款',
                url: 'receipt/list.jhtml'
            }]
        },{
            text: '库存管理',
            iconCls: 'icon-more',
            children: [{
                text: '入库管理',
                url: 'inStock/list.jhtml'
            },{
                text: '出库管理',
                url: 'outStock/list.jhtml'
            },{
                text: '商品库存',
                url: 'goodsStock/list.jhtml'
            }]
        },{
            text: '基本档案',
            iconCls: 'icon-more',
            children: [{
                text: '用户档案',
                url: 'user/list.jhtml'
            },{
                text: '客户档案',
                url: 'customer/list.jhtml'
            },{
                text: '商品档案',
                url: 'goods/list.jhtml'
            }]
        }];
        function sideSelect(e) {
            var tabTitle = e.text;
            var tabUrl = e.url;
            if ($("#centerTabs").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
                $("#centerTabs").tabs("select", tabTitle);
            } else {
                var content = "<iframe src='" + tabUrl + "' frameborder='0' scrolling='auto' style='width:100%;height:100%'>";
                $("#centerTabs").tabs("add", {
                    title: tabTitle,
                    // href: tabUrl,
                    content: content,
                    closable: true
                });
            }
        }
    </script>
</head>
<body>
<body class="easyui-layout" id="layout" style="visibility:hidden;">
[#-- 上 --]
<div data-options="region:'north',split:false,collapsible:false"
     style="height:60px;background:#99CCCC;overflow:hidden;border:none;">
    <div style="position:absolute;top:15px;left:50px;font-size:20px;">
    ${userName} [@shiro.principal/] [@shiro.hasRole name="18826230693"]
        角色[/@shiro.hasRole] [@shiro.hasPermission name="user:add"]权限[/@shiro.hasPermission]
    </div>
    <div style="text-align:center;line-height: 60px;font-size:20px;">
        SSH后台管理系统
    </div>
    <div style="position:absolute;top:15px;right:50px;font-size:20px;">
        <a href="logout.jhtml" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-clear'">退出系统</a>
    </div>
</div>
[#-- 下 --]
<div data-options="region:'south',split:false" style="height:30px;">
    <div style="text-align:center;line-height: 30px;font-size:10px;">
        &copy;版权归属李庆超所有
    </div>
</div>
[#-- 左 --]
<div data-options="region:'west',split:true" style="width:200px;overflow: hidden;">
    <div id="sm" class="easyui-sidemenu" data-options="data:data,onSelect: sideSelect" style="width: 100%;">
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


<script type="text/javascript">
    $(function () {
        //解决闪屏的问题
        window.setTimeout(function () {
            $("#layout").css("visibility", "visible");
        }, 800);
    });
</script>
</body>
</html>