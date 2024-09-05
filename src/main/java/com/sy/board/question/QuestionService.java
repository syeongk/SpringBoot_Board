package com.sy.board.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getQuestionList(){
        return this.questionRepository.findAll();
    }

    public Question addQuestion(String title, String content){
        Question q = new Question();
        q.setTitle(title);
        q.setContent(content);
        q.setCreatedAt(LocalDateTime.now());
        return this.questionRepository.save(q);

    }

    public Question getQuestion(Integer id) {
        Optional<Question> oq = this.questionRepository.findById(id);
        if (oq.isPresent()){
            return oq.get();
        }
        else{
            //TODO: 예외 처리
            return null;
        }
    }
}
