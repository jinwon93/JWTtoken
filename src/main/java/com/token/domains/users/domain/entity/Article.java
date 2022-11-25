package com.token.domains.users.domain.entity;


import com.token.domains.users.domain.UsersEntity;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column
    private LocalDateTime updateAt = LocalDateTime.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersEntity users;


    public static Article createArticle(String title , String body , UsersEntity users) {

        Article article = new Article();
        article.title = title;
        article.body = body;
        article.users = users;

        return  article;
    }


    public static  Article changeArticle(Article article , String title , String body) {

        article.title = title;
        article.body = body;
        return  article;
    }

}
