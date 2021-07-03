package com.example.demo.Theme;


import com.example.demo.Answer.Answer;
import com.example.demo.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "themes")
@Builder
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String text;

    private LocalDateTime time;

    private Integer qty;


    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "theme")
    private List<Answer> answers;

}
