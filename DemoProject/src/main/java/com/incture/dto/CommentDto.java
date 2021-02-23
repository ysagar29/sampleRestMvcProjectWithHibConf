package com.incture.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public @Data class CommentDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String commentId;

	private String comments;

	private String updatedBy;

	private Date commentTime;

	private String refDocNum;

	@Override
	public Boolean getValidForUsage() {
		return null;
	}

}
