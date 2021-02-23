package com.incture.dto;

import java.io.Serializable;

import javax.persistence.Transient;

public abstract class BaseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean isNullable = true;

	@Transient
	public abstract Boolean getValidForUsage();

}
