package com.sy.board.answer;

import com.sy.board.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer addAnswer(String content, Question question){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(question);
        answer.setCreatedAt(LocalDateTime.now());

        return this.answerRepository.save(answer);
    }

    public List<Answer> getAnswerList(){
        return this.answerRepository.findAll();
    }
}
