package com.sy.board.question;

import com.sy.board.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    private Integer id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
