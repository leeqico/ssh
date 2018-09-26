package com.lqc.common.query;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 属性筛选
 * @author liqc
 *
 */
public class PropertyFilter implements Comparable<PropertyFilter>, Serializable {

	private static final long serialVersionUID = -899248769022420567L;

	/**
	 * 运算符
	 */
	public enum Operator {

		/** 等于 */
		eq,

		/** 不等于 */
		ne,

		/** 大于 */
		gt,

		/** 小于 */
		lt,

		/** 大于等于 */
		ge,

		/** 小于等于 */
		le,

		/** 相似 */
		like,

		/** 包含 */
		in,
		
		/** 不包含 */
		notIn,

		/** 为Null */
		isNull,

		/** 不为Null */
		isNotNull;

	}

	/** 属性 */
	private String property;

	/** 运算符 */
	private Operator operator;

	/** 值 */
	private Object value;
	
	/** 类别名 */
	private String classAlias;

	public PropertyFilter() {
	}

	/**
	 * @param property 属性
	 * @param operator 运算符
	 * @param value 值
	 */
	public PropertyFilter(String property, Operator operator, Object value) {
		this.property = property;
		this.operator = operator;
		this.value = value;
	}
	
	/**
	 * @param property 属性
	 * @param operator 运算符
	 * @param value 值
	 * @param classAlias 类别名
	 */
	public PropertyFilter(String property, Operator operator, Object value, String classAlias) {
		this.property = property;
		this.operator = operator;
		this.value = value;
		this.classAlias = classAlias;
	}
	
	/**
	 * @return 属性
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property 属性
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @return 运算符
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * @param operator 运算符
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * @return 值
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value 值
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return 类别名
	 */
	public String getClassAlias() {
		return classAlias;
	}

	/**
	 * @param classAlias 类别名
	 */
	public void setClassAlias(String classAlias) {
		this.classAlias = classAlias;
	}

	/**
	 * 返回等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 等于筛选
	 */
	public static PropertyFilter eq(String property, Object value) {
		return new PropertyFilter(property, Operator.eq, value);
	}
	
	/**
	 * 返回等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 等于筛选
	 */
	public static PropertyFilter eq(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.eq, value, classAlias);
	}

	/**
	 * 返回不等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 不等于筛选
	 */
	public static PropertyFilter ne(String property, Object value) {
		return new PropertyFilter(property, Operator.ne, value);
	}
	
	/**
	 * 返回不等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 不等于筛选
	 */
	public static PropertyFilter ne(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.ne, value, classAlias);
	}

	/**
	 * 返回大于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 大于筛选
	 */
	public static PropertyFilter gt(String property, Object value) {
		return new PropertyFilter(property, Operator.gt, value);
	}
	
	/**
	 * 返回大于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 大于筛选
	 */
	public static PropertyFilter gt(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.gt, value, classAlias);
	}

	/**
	 * 返回小于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 小于筛选
	 */
	public static PropertyFilter lt(String property, Object value) {
		return new PropertyFilter(property, Operator.lt, value);
	}
	
	/**
	 * 返回小于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 小于筛选
	 */
	public static PropertyFilter lt(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.lt, value, classAlias);
	}
	
	/**
	 * 返回大于等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 大于等于筛选
	 */
	public static PropertyFilter ge(String property, Object value) {
		return new PropertyFilter(property, Operator.ge, value);
	}

	/**
	 * 返回大于等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 大于等于筛选
	 */
	public static PropertyFilter ge(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.ge, value, classAlias);
	}

	/**
	 * 返回小于等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 小于等于筛选
	 */
	public static PropertyFilter le(String property, Object value) {
		return new PropertyFilter(property, Operator.le, value);
	}
	
	/**
	 * 返回小于等于筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 小于等于筛选
	 */
	public static PropertyFilter le(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.le, value, classAlias);
	}
	
	/**
	 * 返回相似筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 相似筛选
	 */
	public static PropertyFilter like(String property, Object value) {
		return new PropertyFilter(property, Operator.like, value);
	}

	/**
	 * 返回相似筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 相似筛选
	 */
	public static PropertyFilter like(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.like, value, classAlias);
	}
	
	/**
	 * 返回包含筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @return 包含筛选
	 */
	public static PropertyFilter in(String property, Object value) {
		return new PropertyFilter(property, Operator.in, value);
	}

	/**
	 * 返回包含筛选
	 * 
	 * @param property 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 包含筛选
	 */
	public static PropertyFilter in(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.in, value, classAlias);
	}
	
	/**
	 * 返回不包含筛选
	 * 
	 * @param roperty 属性
	 * @param value 值
	 * @return 不包含筛选
	 */
	public static PropertyFilter notIn(String property, Object value) {
		return new PropertyFilter(property, Operator.notIn, value);
	}
	
	/**
	 * 返回不包含筛选
	 * 
	 * @param roperty 属性
	 * @param value 值
	 * @param classAlias 类别名
	 * @return 不包含筛选
	 */
	public static PropertyFilter notIn(String property, Object value, String classAlias) {
		return new PropertyFilter(property, Operator.notIn, value, classAlias);
	}
	
	/**
	 * 返回为Null筛选
	 * 
	 * @param property 属性
	 * @return 为Null筛选
	 */
	public static PropertyFilter isNull(String property) {
		return new PropertyFilter(property, Operator.isNull, null);
	}

	/**
	 * 返回为Null筛选
	 * 
	 * @param property 属性
	 * @param classAlias 类别名
	 * @return 为Null筛选
	 */
	public static PropertyFilter isNull(String property, String classAlias) {
		return new PropertyFilter(property, Operator.isNull, null, classAlias);
	}
	
	/**
	 * 返回不为Null筛选
	 * 
	 * @param property 属性
	 * @return 不为Null筛选
	 */
	public static PropertyFilter isNotNull(String property) {
		return new PropertyFilter(property, Operator.isNotNull, null);
	}

	/**
	 * 返回不为Null筛选
	 * 
	 * @param property 属性
	 * @param classAlias 类别名
	 * @return 不为Null筛选
	 */
	public static PropertyFilter isNotNull(String property, String classAlias) {
		return new PropertyFilter(property, Operator.isNotNull, null, classAlias);
	}

	@Override
	public int compareTo(PropertyFilter propertyFilter) {
		if (operator == null || propertyFilter.getOperator() == null) {
			return 0;
		}
		return new CompareToBuilder().append(operator.ordinal(), propertyFilter.getOperator().ordinal()).toComparison();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		PropertyFilter other = (PropertyFilter) obj;
		return new EqualsBuilder().append(getProperty(), other.getProperty()).append(getOperator(), other.getOperator()).append(getValue(), other.getValue()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getProperty()).append(getOperator()).append(getValue()).toHashCode();
	}

}
