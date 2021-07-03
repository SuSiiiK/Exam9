package com.example.demo.Answer;

import com.example.demo.Theme.Theme;
import com.example.demo.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "themes_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
