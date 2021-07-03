package com.example.demo.Theme;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
@AllArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    public Page<Theme> findAllThemes(Pageable pageable) {
        return themeRepository.findAll(pageable);
    }

    public void save(Theme theme) {
        themeRepository.save(theme);
    }

    public boolean existbyId(Long id) {
        return themeRepository.existsById(id);
    }

    public Theme findById(Long id) {
        return themeRepository.findById(id).get();
    }
}
