package com.lqc.common.query;

import java.io.Serializable;

/**
 * 筛选规则
 * @author liqc
 */
public class FilterRule implements Serializable{

	private static final long serialVersionUID = -5706536175846605649L;
	
	public enum Op {
		
		/** 包含 */
		contains,
		
	}
	
	/** 字段 */
	private String field;
	
	/** 运算符 */
	private Op op;
	
	/** 值 */
	private Object value;
	
	/**
	 * @return 字段
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field 字段
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return 运算符
	 */
	public Op getOp() {
		return op;
	}

	/**
	 * @param op 运算符
	 */
	public void setOp(Op op) {
		this.op = op;
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

}
