package com.lqc.common.query;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * HQL子句
 * @author liqc
 */
public final class HQLClause implements Serializable{

	private static final long serialVersionUID = 560221757031423690L;
	
	/** 子句 */
	private String clause;
	
	/** 参数 */
	private Map<String, Object> parameters;

	public HQLClause() {
		this(StringUtils.EMPTY, Collections.emptyMap());
	}

	/**
	 * @param clause 子句
	 * @param parameters 参数
	 */
	public HQLClause(String clause, Map<String, Object> parameters) {
		this.clause = clause;
		this.parameters = parameters;
	}

	/**
	 * @return 子句
	 */
	public String getClause() {
		return clause;
	}

	/**
	 * @param clause 子句
	 */
	public void setClause(String clause) {
		this.clause = clause;
	}

	/**
	 * @return 参数
	 */
	public Map<String, Object> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters 参数
	 */
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * @return 空HQL子句
	 */
	public static HQLClause empty() {
		return new HQLClause();
	}
	
	@Override
	public String toString() {
		return clause;
	}
	
}
