package com.token.domains.article.entity;


import com.token.domains.users.domain.UsersEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recommend {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "user_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UsersEntity users;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;



    public Recommend(UsersEntity users, Article article) {
        this.users = users;
        this.article = article;
    }
}
