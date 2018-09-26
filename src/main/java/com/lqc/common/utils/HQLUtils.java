package com.lqc.common.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.lqc.common.exception.HQLParseException;
import com.lqc.common.query.ClauseConnector;
import com.lqc.common.query.HQLClause;
import com.lqc.common.query.PropertyFilter;
import com.lqc.common.query.PropertyFilter.Operator;

/**
 * Utils - HQL
 * @author liqc
 *
 */
public final class HQLUtils {
	
	/** 参数名称 */
	private static final String PARAMETER = "hqlParam";
	
	/**
	 * 不可实例化
	 */
	private HQLUtils() {
	}
	
	/**
	 * 将属性筛选转为where子句
	 * 
	 * <p>返回的where子句：
	 * <li>1.本方法会根据操作符覆盖索引的优先级对字段排序，例如like一定排在最后；
	 * <li>2.本方法and连接所有的字段筛，包括like。
	 * 
	 * @param connector 连接符，在返回值最前加入该连接符；null表示无连接符；where子句为空时无连接符
	 * @param propertyFilters 属性筛选
	 */
	public static HQLClause toWhereClause(ClauseConnector connector, PropertyFilter... propertyFilters) {
		if (ArrayUtils.isEmpty(propertyFilters)) {
			return HQLClause.empty();
		}
		
		// 排序（覆盖索引的属性筛选优先）
		Arrays.sort(propertyFilters);
		
		StringBuilder whereClauseTemp = new StringBuilder();
		final String propertyFilterConnector = " " + toString(ClauseConnector.and) + " ";
		Map<String, Object> parameters = new HashMap<>(HashMapUtils.bestInitialCapacity(propertyFilters.length));
		boolean isFirst = true;
		for (PropertyFilter propertyFilter : propertyFilters) {
			
			String classAlias = propertyFilter.getClassAlias();
			Operator operator = propertyFilter.getOperator();
			
			if (isFirst) {
				isFirst = false;
			} else {
				// 连接符
				whereClauseTemp.append(propertyFilterConnector);
			}
			
			// 属性筛选条件
			switch (operator) {
				case eq:
				case ne:
				case gt:
				case lt:
				case ge:
				case le:
				case like:
				case in:
					String parameterName = PARAMETER + parameters.size();
					whereClauseTemp.append(toHqlExpression(propertyFilter.getProperty(), classAlias)).append(" ").append(toHqlOperator(operator));
					boolean isIn = Operator.in.equals(operator);
					if (isIn) {	// 为in加上括号
						whereClauseTemp.append(" (");
					}
					whereClauseTemp.append(" :").append(parameterName);
					if (isIn) {	// 为in加上括号
						whereClauseTemp.append(" )");
					}
					parameters.put(parameterName, toHqlValue(propertyFilter));
					break;
				case notIn:
					String parameterName1 = PARAMETER + parameters.size();
					whereClauseTemp.append(toHqlExpression(propertyFilter.getProperty(), classAlias)).append(" ").append(toHqlOperator(operator));
					boolean isNotIn = Operator.notIn.equals(operator);
					if (isNotIn) {	// 为in加上括号
						whereClauseTemp.append(" (");
					}
					whereClauseTemp.append(" :").append(parameterName1);
					if (isNotIn) {	// 为in加上括号
						whereClauseTemp.append(" )");
					}
					parameters.put(parameterName1, toHqlValue(propertyFilter));
					break;
				case isNull:
				case isNotNull:
					whereClauseTemp.append(toHqlExpression(propertyFilter.getProperty(), classAlias)).append(" ").append(toHqlOperator(operator));
					break;
			}
		}
		
		String whereClause = StringUtils.EMPTY;
		if (connector != null) {
			whereClause += " " + toString(connector);
		}
		whereClause += " ( " + whereClauseTemp + " )";
		
		return new HQLClause(whereClause, parameters);
	}
	
	/**
	 * 将连接符转为字符串
	 * 
	 * @param connector 连接符
	 * @return
	 */
	private static String toString(ClauseConnector connector) {
		String ret = null;
		
		switch (connector) {
		case where:
			ret = "where";
			break;
		case and:
			ret = "and";
			break;
		case or:
			ret = "or";
			break;
		case orderBy:
			ret = "order by";
			break;
		default:
			ret = StringUtils.EMPTY;
			break;
		}
		return ret;
	}
	
	/**
	 * 将属性转为HQL表达式
	 * 
	 * @param property 属性
	 * @param classAlias 类别名
	 * @return
	 */
	private static String toHqlExpression(final String property, final String classAlias) {
		String expr = property;
		if (StringUtils.isNotEmpty(classAlias)) {	// 有别名
			expr = classAlias + "." + expr;
		}
		return expr;
	}
	
	/**
	 * 将属性筛选操作符转为HQL操作符
	 * 
	 * @param operator 属性筛选操作符
	 * @return
	 */
	private static String toHqlOperator(Operator operator) {
		String ret = null;
		switch (operator) {
			case eq:
				ret = "=";
				break;
			case ne:
				ret = "<>";
				break;
			case gt:
				ret = ">";
				break;
			case lt:
				ret = "<";
				break;
			case ge:
				ret = ">=";
				break;
			case le:
				ret = "<=";
				break;
			case like:
				ret = "like";
				break;
			case in:
				ret = "in";
				break;
			case notIn:
				ret = "not in";
				break;
			case isNull:
				ret = "is null";
				break;
			case isNotNull:
				ret = "is not null";
				break;
		}
		return ret;
	}
	
	/**
	 * 将属性筛选值转为HQL中的值
	 * 
	 * @param propertyFilter 属性筛选
	 * @return
	 * @throws HQLParseException HQL转换异常
	 */
	private static Object toHqlValue(PropertyFilter propertyFilter) {
		Object ret = null;
		
		Object value = propertyFilter.getValue();
		if (value == null) {
			throw new HQLParseException("Value of property filter cannot be null.");
		}
		
		Operator operator = propertyFilter.getOperator();
		Class<?> valueClass = value.getClass();
		
		if (value instanceof String) {	// 字符串
			// 如果是like操作也不加%，而是由该工具类使用者自主添加%，保证灵活性
			ret = value;
		} else if (value instanceof Number || value instanceof Enum || value instanceof Boolean || value instanceof Date) {	// 数值 或 枚举 或 布尔值  或 日期
			ret = value;
		} else if (Operator.in.equals(operator) || Operator.notIn.equals(operator)) {	// in 或 notIn 操作符
			if (value instanceof Collection) {	// 集合
				Collection<?> collectionValue = (Collection<?>) value;
				if (CollectionUtils.isEmpty(collectionValue)) {
					throw new HQLParseException("Value of property filter cannot be empty when using \'in\' operator.");
				}
				ret = collectionValue;
			} else if (valueClass.isArray()) {	// 数组
				Object[] arrayValue = (Object[]) value;
				if (ArrayUtils.isEmpty(arrayValue)) {
					throw new HQLParseException("Value of property filter cannot be empty when using \'in\' operator.");
				}
				ret = arrayValue;
			} else {
				throw new HQLParseException("Unsupported property filter: operator=" + operator + ", value=" + valueClass.getName() + ".");
			}
		} else {
			throw new HQLParseException("Unsupported property filter: operator=" + operator + ", value=" + valueClass.getName() + ".");
		}
		
		return ret;
	}
	
}
