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
@Builder
public class UsersEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;


  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String password;


  public void setPw(String pw) {
    this.password = password;
  }
  @Enumerated(EnumType.STRING)
  private Authority authority;

  @Builder
  public UsersEntity(Long id  ,String userId, String password  , Authority authority) {

    this.id = id;
    this.userId = userId;
    this.password = password;
    this.authority = authority;
  }
}
