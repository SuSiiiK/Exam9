package com.example.demo.Controller;

import com.example.demo.Answer.Answer;
import com.example.demo.Answer.AnswerService;
import com.example.demo.Theme.Theme;
import com.example.demo.Theme.ThemeService;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class MainRestController {
    private final UserService userService;
    private final ThemeService themeService;
    private final AnswerService answerService;

    @ResponseBody
    @PostMapping("/addTheme")
    public ResponseEntity<?> addComment(@RequestParam("text") String text, @RequestParam("name") String name, Principal principal) {
        User byEmail = userService.findByEmail(principal.getName());
        Theme theme = Theme.builder()
                .user(byEmail)
                .time(LocalDateTime.now())
                .text(text)
                .name(name)
                .qty(0)
                .build();
        themeService.save(theme);
        return ResponseEntity.ok(theme);
    }

    @ResponseBody
    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestParam("text") String message, @RequestParam("id") Long id, Principal principal) {
        Theme theme = themeService.findById(id);
        User user = userService.findByEmail(principal.getName());
        Answer answer = Answer.builder()
                .theme(theme)
                .user(user)
                .message(message)
                .time(LocalDateTime.now())
                .build();
        answerService.saveAnswer(answer);
        return ResponseEntity.ok(answer);
    }
}
