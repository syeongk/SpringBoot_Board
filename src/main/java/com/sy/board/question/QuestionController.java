package com.sy.board.question;

import com.sy.board.answer.AnswerForm;
import com.sy.board.answer.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;


    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getQuestionList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id")Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/add")
    public String addQuestion(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/add")
    public String addedQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.addQuestion(questionForm.getTitle(), questionForm.getContent());
        return "redirect:/question/list";
    }

}
