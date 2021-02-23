package com.incture.services;

import org.springframework.http.ResponseEntity;

import com.incture.dto.CommentDto;

public interface CommentService {

	public ResponseEntity<?> saveOrUpdateComment(CommentDto commentDto);

	public ResponseEntity<?> listAllComments();

	public ResponseEntity<?> deleteCommentById(String commentId);

	public ResponseEntity<?> getCommentById(String commentId);

	public ResponseEntity<?> getCommentListByRefId(String refId);

}
