package com.token.domains.users.application;


import com.token.commons.config.SecurityUtil;
import com.token.domains.users.application.dto.UsersResponseDto;
import com.token.domains.users.domain.UsersEntity;
import com.token.domains.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {


    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;






    public  UsersResponseDto getMyInfoBySecurity() {

        return usersRepository.findById(SecurityUtil.getCurrentUserId())
                .map(UsersResponseDto::of)
                .orElseThrow( () -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }

    @Transactional
    public UsersResponseDto changeUserNickname (String userId , String nickname) {
        UsersEntity users = usersRepository.findByUserId(userId).orElseThrow( ()  -> new RuntimeException("로그인 유저 정보가 없습니다"));
        users.setNickname(nickname);
        return UsersResponseDto.of(usersRepository.save(users));
    }

    @Transactional
    public UsersResponseDto changePassword(String userId , String exPassword , String newPassword) {
        UsersEntity  users = usersRepository.findById(SecurityUtil.getCurrentUserId()).orElseThrow( ()-> new RuntimeException("로그인 유저 정보가 없습니다 "));
        if (!passwordEncoder.matches(exPassword , users.getPassword())) {
            throw  new RuntimeException("비밀번호가 맞지 않습니다");
        }
        users.setPassword(passwordEncoder.encode(newPassword));
        return UsersResponseDto.of(usersRepository.save(users));
    }

    public List<UsersEntity> findUsers() {
        return usersRepository.findAll();
    }


}
