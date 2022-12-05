package com.token.domains.article.service;


import com.token.domains.article.entity.Article;
import com.token.domains.article.entity.ArticleRepository;
import com.token.domains.users.application.dto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {


    private final ArticleRepository articleRepository;

    public List<PageResponseDto> allArticle()  {

        List<Article> articles = articleRepository.findAll();

        return  articles
                .stream()
                .map(PageResponseDto::of)
                .collect(Collectors.toList());
    }
}
