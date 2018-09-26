// 数据表
var $dataGrid;

$(function() {
	
	$dataGrid = $('#dataGrid');
	
});

//过滤规则
var filterRules = [];

//将查询选项组装成FiledFilter
function transformQueryParas(form) {
	var dataArray = $('#form').serialize();
	// 组装fieldFilter
	var array = dataArray.split("&"); // "1=sth,2=sth,3=sth"
	var filterFields = new Array();
	array.forEach(function(item) {
		var items = item.split("=");
		if(items.length > 1 && items[1] != "" && decodeURIComponent(items[1],true) != "全部") { // 说明存在相应的value
			var key = items[0];
			var value = items[1];
			var keyclass = $("[id='"+key+"']").attr('class');
			if(keyclass.indexof('easyui-textbox') != -1){
				var fieldFilter = '{"field":"'+key+'","op":"contains","value":"'+value+'"}';
				filterFields.push(fieldFilter);
			}
		}
	});
	var filterRules = "[" + filterFields.join(",") + "]";
	return filterRules;
}

function formSubmit() {
	$dataGrid.datagrid('clearSelections');
	$dataGrid.datagrid('load', {'filterRules': decodeURIComponent(transformQueryParas(),true)});
}