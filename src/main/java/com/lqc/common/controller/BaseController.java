package com.lqc.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.lqc.common.query.FilterRule;
import com.lqc.common.query.PropertyFilter;
import com.lqc.common.query.FilterRule.Op;
import com.lqc.common.query.PropertyFilter.Operator;
import com.lqc.common.utils.HashMapUtils;

/**
 * 基类
 * @author liqc
 */
public abstract class BaseController {

	/**
	 * 转换属性筛选
	 * @param filterRules
	 * @return
	 */
	protected PropertyFilter[] parsePropertyFilters(String filterRules) {
		List<FilterRule> filterRuleList = JSON.parseArray(filterRules, FilterRule.class);
		List<PropertyFilter> propertyFilterList = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(filterRuleList)) {
			for (FilterRule filterRule : filterRuleList) {
				String field = filterRule.getField();
				Op op = filterRule.getOp();
				Object value = filterRule.getValue();
				Operator operator = null;
				switch (op) {
					case contains:
						operator = Operator.like;
						value = new StringBuilder("%").append(value).append("%").toString();
						break;
					default:
						continue;
				}
				propertyFilterList.add(new PropertyFilter(field, operator, value));
			}
		}
		return propertyFilterList.toArray(new PropertyFilter[0]);
	}
	
}
