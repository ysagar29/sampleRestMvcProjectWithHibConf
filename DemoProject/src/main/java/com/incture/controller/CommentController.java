package com.incture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.incture.dto.CommentDto;
import com.incture.services.CommentService;

@RestController
@EnableWebMvc
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService services;

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto) {
		return services.saveOrUpdateComment(commentDto);
	}

	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateComment(@RequestBody CommentDto commentDto) {
		System.err.println("Comment Updated Successfully");
		if (commentDto.getCommentId() != null) {
			return services.saveOrUpdateComment(commentDto);
		} else {
			return new ResponseEntity<>("Comment Id field is mandatory.", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> listAllComment() {
		return services.listAllComments();
	}

	@DeleteMapping("/deleteById/{commentId}")
	public ResponseEntity<?> deleteCommentById(@PathVariable("commentId") String commentId) {
		return services.deleteCommentById(commentId);
	}

	@GetMapping("/findCommentById/{commentId}")
	public ResponseEntity<?> findCommentById(@PathVariable("commentId") String commentId) {
		return services.getCommentById(commentId);
	}

	@GetMapping("/findByRefDocNum/{refDocNum}")
	public ResponseEntity<?> findCommentListByRefDocNum(@PathVariable("refDocNum") String refDocNum) {
		return services.getCommentListByRefId(refDocNum);
	}

}
