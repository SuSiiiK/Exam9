package com.example.demo.User;


import com.example.demo.Theme.Theme;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @ToString.Exclude
    @OneToMany
    private List<Theme> themes;

    @Builder.Default
    private boolean enabled = true;

    @Builder.Default
    private String role = "USER";

}
