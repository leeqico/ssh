$.extend($.fn.validatebox.defaults.rules, {
	mobile: {// 手机号码
		validator : function(value) {
			return /^(13|14|15|16|17|18|19)\d{9}$/i.test(value);
		},
		message : '请输入正确的手机号码'
	},
});