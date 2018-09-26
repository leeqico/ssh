package com.lqc.common.query;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *  分页信息
 * @author liqc
 *
 */
public class Pageable implements Serializable{

	private static final long serialVersionUID = 2379452146094881305L;
	
	/** 最小页码 */
	private static final int MIN_PAGE = 0;
	
	/** 最小每页记录数 */
	private static final int MIN_ROWS = 1;
	
	/** 最大每页记录数 */
	private static final int MAX_ROWS = Integer.MAX_VALUE;
	
	/** 默认页码 */
	private static final int DEFAULT_PAGE = MIN_PAGE;
	
	/** 默认每页记录数 */
	private static final int DEFAULT_ROWS = 50;
	
	private int page = DEFAULT_PAGE;
	
	private int rows = DEFAULT_ROWS;
	
	public Pageable() {
	}
	
	public Pageable(Integer page, Integer rows) {
		if (page != null && page >=MIN_PAGE) {
			this.page = page;
		}
		if (rows != null && rows >= MIN_ROWS && rows <= MAX_ROWS) {
			this.rows = rows;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page < MIN_PAGE) {
			page = DEFAULT_PAGE;
		}
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		if (rows < MIN_ROWS || rows > MAX_ROWS) {
			rows = DEFAULT_ROWS;
		}
		this.rows = rows;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPage()).append(getRows()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pageable other = (Pageable) obj;
		return new EqualsBuilder().append(getPage(), other.getPage()).append(getRows(), other.getRows()).isEquals();
	}
	
}
