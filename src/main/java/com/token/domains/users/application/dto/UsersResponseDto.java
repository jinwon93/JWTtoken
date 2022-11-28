package com.token.domains.users.application.dto;


import com.token.domains.users.domain.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersResponseDto {

    private String userId;
    private String nickname;


    public static  UsersResponseDto of(UsersEntity users) {

        return UsersResponseDto.builder()
                .userId(users.getUserId())
                .nickname(users.getNickname())
                .build();
    }
}
