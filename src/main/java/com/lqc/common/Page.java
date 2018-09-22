package com.lqc.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Page<T> implements Serializable {
	
	private static final long serialVersionUID = -4976782667943852089L;
	
	/** 总记录数 */
	private final long total;
	
	/** 内容 */
	private final List<T> rows;
	
	public Page() {
		this(0L, Collections.emptyList());
	}

	/**
	 * @param total 总记录数
	 * @param rows 内容
	 */
	public Page(long total, List<T> rows) {
		this.total = total;
		this.rows = rows == null ? Collections.emptyList() : rows;
	}

	/**
	 * @return 总记录数
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @return 内容
	 */
	public List<T> getRows() {
		return rows;
	}
	
}
