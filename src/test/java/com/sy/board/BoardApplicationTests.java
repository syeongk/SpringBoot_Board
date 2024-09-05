package com.sy.board;

import com.sy.board.answer.AnswerRepository;
import com.sy.board.answer.AnswerService;
import com.sy.board.question.Question;
import com.sy.board.question.QuestionRepository;
import com.sy.board.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Test
	void test() {

		for (int i=1; i<=300; i++){
			String title = String.format("테스트 데이터입니다 : [%03d]", i);
			String content = "내용무";
			this.questionService.addQuestion(title, content);
		}


	}

}
