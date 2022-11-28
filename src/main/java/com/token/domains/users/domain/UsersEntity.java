package com.token.domains.users.domain;

import com.token.commons.entity.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Entity
@NoArgsConstructor
@Builder
public class UsersEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;


  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String password;


  @Column(nullable = false)
  private String nickname;



  @Enumerated(EnumType.STRING)
  private Authority authority;


  public void setPassword(String password) {
    this.password = password;
  }


  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  @Builder
  public UsersEntity(Long id  ,String userId, String password  , String nickname ,  Authority authority) {

    this.id = id;
    this.userId = userId;
    this.password = password;
    this.nickname = nickname;
    this.authority = authority;
  }
}
