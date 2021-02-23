package com.incture.dao;

import java.util.List;

import com.incture.dto.CommentDto;
import com.incture.exceptions.ExecutionFault;

public interface CommentDao {

	public String saveOrUpdateComment(CommentDto commentDto) throws ExecutionFault;

	public List<CommentDto> listAllComments();

	public CommentDto getCommentById(String commentId);

	public String deleteCommentById(String commentId) throws ExecutionFault;

	public List<CommentDto> getCommentListByRefId(String refId);
}
