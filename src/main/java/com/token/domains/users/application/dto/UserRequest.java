package com.token.domains.users.application.dto;

import com.token.commons.entity.Authority;
import com.token.domains.users.domain.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
   private String userId;
   private String userPassword;
   private String nickname;

   public UsersEntity toUsers(PasswordEncoder passwordEncoder) {
      return UsersEntity.builder()
              .userId(userId)
              .password(passwordEncoder.encode(userPassword))
              .nickname(nickname)
              .authority(Authority.ROLE_USER)
              .build();
   }


   public UsernamePasswordAuthenticationToken toAuthentication() {
      return  new UsernamePasswordAuthenticationToken(userId , userPassword);
   }

}
