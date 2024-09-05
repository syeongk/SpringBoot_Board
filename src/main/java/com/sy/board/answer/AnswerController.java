package com.sy.board.answer;

import com.sy.board.question.Question;
import com.sy.board.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("answer/add/{id}")
    public String addedAnswer(Model model, @PathVariable("id")Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.addAnswer(answerForm.getContent(), question);
        return "redirect:/question/detail/{id}";
    }

}
