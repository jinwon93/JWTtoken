package com.token.domains.users.presentation;


import com.token.domains.users.application.UserService;
import com.token.domains.users.application.dto.ChangePasswordRequestDto;
import com.token.domains.users.application.dto.UserRequest;
import com.token.domains.users.application.dto.UsersResponseDto;
import com.token.domains.users.domain.UsersEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;




    @ApiOperation(value = "회원정보" , response = UsersEntity.class)
    @GetMapping("/info")
    public ResponseEntity<List<UsersEntity>> findUser() {
        return ResponseEntity.ok().body(userService.findUsers());
    }


    @PostMapping("/nickname")
    public ResponseEntity<UsersResponseDto> setUserNickname (@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.changeUserNickname(request.getUserId() , request.getNickname()));

    }

    public ResponseEntity<UsersResponseDto> setUserPassword (@RequestBody  ChangePasswordRequestDto request) {

        return ResponseEntity.ok(userService.changePassword(request.getExPassword() , request.getNewPassword() , request.getUserId()));
    }
}
