package com.token.domains.users.domain;

import com.token.commons.entity.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "users")
@Entity
@NoArgsConstructor
public class UsersEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;


  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String pw;



  @Enumerated(EnumType.STRING)
  private Authority authority;

  @Builder
  public UsersEntity(Long id  ,String userId, String pw  , Authority authority) {

    this.id = id;
    this.userId = userId;
    this.pw = pw;
    this.authority = authority;
  }
}
