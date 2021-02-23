package com.incture.services;

import static com.incture.utils.HelperClass.checkString;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incture.dao.CommentDao;
import com.incture.dto.CommentDto;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private CommentDao commentRepo;

	@Override
	public ResponseEntity<?> saveOrUpdateComment(CommentDto commentDto) {
		try {
			if (!checkString(commentDto.getRefDocNum())) {
				String msg = commentRepo.saveOrUpdateComment(commentDto);
				logger.error("msg : " + msg);
				if (msg == null) {
					return new ResponseEntity<>("Creation Failed", HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(msg, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Ref Doc Number field is mandatory", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error(e + " on " + e.getStackTrace()[1]);
			return new ResponseEntity<>("Error occur at : " + e + " on " + e.getStackTrace()[1],
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> listAllComments() {
		try {
			List<CommentDto> list = commentRepo.listAllComments();
			logger.error("list : " + list);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No data found", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			logger.error(e + " on " + e.getStackTrace()[1]);
			return new ResponseEntity<>("Error occur at : " + e + " on " + e.getStackTrace()[1],
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> deleteCommentById(String commentId) {
		try {
			if (!checkString(commentId)) {
				String msg = commentRepo.deleteCommentById(commentId);
				if (msg != null) {
					return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
				} else {
					return new ResponseEntity<>("Error occur", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} else {
				return new ResponseEntity<>("Comment Id field is mandatory", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error(e + " on " + e.getStackTrace()[1]);
			return new ResponseEntity<>("Error occur at : " + e + " on " + e.getStackTrace()[1],
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getCommentById(String commentId) {
		try {
			if (!checkString(commentId)) {
				CommentDto commentDto = commentRepo.getCommentById(commentId);
				if (commentDto != null) {
					return new ResponseEntity<>(commentDto, HttpStatus.ACCEPTED);
				} else {
					return new ResponseEntity<>("Comment is not available for Comment id : " + commentId,
							HttpStatus.NO_CONTENT);
				}
			} else {
				return new ResponseEntity<>("Comment Id field is mandatory", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error(e + " on " + e.getStackTrace()[1]);
			return new ResponseEntity<>("Error occur at : " + e + " on " + e.getStackTrace()[1],
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getCommentListByRefId(String refId) {
		try {
			List<CommentDto> list = commentRepo.getCommentListByRefId(refId);
			if (list != null && !list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>("No comment found for Ref Request Id : " + refId, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			logger.error(e + " on " + e.getStackTrace()[1]);
			return new ResponseEntity<>("Error occur at : " + e + " on " + e.getStackTrace()[1],
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
