package com.example.demo.Theme;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long> {
    Page<Theme> findAll(Pageable pageable);
}
