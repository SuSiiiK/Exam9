package com.example.demo.Answer;

import com.example.demo.Theme.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
    Page<Answer> findAllByTheme_Id(Long theme_id, Pageable pageable);
}
