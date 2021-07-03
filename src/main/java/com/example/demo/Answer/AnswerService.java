package com.example.demo.Answer;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Page<Answer> findByThemeId(Long id, Pageable pageable) {
        return answerRepository.findAllByTheme_Id(id, pageable);
    }



    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
