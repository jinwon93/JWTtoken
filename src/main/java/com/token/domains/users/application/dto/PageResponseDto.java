package com.token.domains.users.application.dto;


import com.token.domains.article.entity.Article;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class PageResponseDto {

    private Long articleId;
    private String articleTitle;
    private String userNickname;
    private String createdAt;


    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                .articleId(article.getId())
                .articleTitle(article.getTitle())
                .userNickname(article.getUsers().getNickname())
                .createdAt(article.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}
