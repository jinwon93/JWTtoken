package com.token.domains.users.application.dto;

import com.token.commons.entity.Authority;
import com.token.domains.users.domain.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
   private String userId;
   private String userPw;

   public UsersEntity toUsers(PasswordEncoder passwordEncoder) {
      return UsersEntity.builder()
              .userId(userId)
              .pw(passwordEncoder.encode(userPw))
              .authority(Authority.ROLE_USER)
              .build();
   }


}
