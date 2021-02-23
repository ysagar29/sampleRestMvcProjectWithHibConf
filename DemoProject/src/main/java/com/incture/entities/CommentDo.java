package com.incture.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMMENT")
public @Data class CommentDo implements BaseDo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMMENT_ID", length = 100)
	private String commentId = UUID.randomUUID().toString();

	@Column(name = "COMMENT")
	private String comments;

	@Column(name = "UPDATED_BY", length = 20)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMENT_TIME")
	private Date commentTime;

	@Column(name = "REF_DOC_NUM", length = 100)
	private String refDocNum;

	@Override
	public Object getPrimaryKey() {
		return commentId;
	}
}
