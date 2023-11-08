package com.example.cinema.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Rated {
    P("Dành cho mọi khán giả"),
    K("Dưới 13 tuổi cần cha/mẹ cho phép"),
    C13("Dành cho khán giả trên 13 tuổi"),
    C16("Dành cho khán giả trên 16 tuổi"),
    C18("Dành cho khán giả trên 18 tuổi");

    private final String description;
}