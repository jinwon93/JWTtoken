package com.token.domains.users.presentation;

import com.token.commons.Jwt.TokenUtils;
import com.token.domains.users.application.UserService;
import com.token.domains.users.application.dto.TokenResponse;
import com.token.domains.users.application.dto.UserRequest;
import com.token.domains.users.domain.UsersEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/")
@RestController
@Api(tags = {"JoinMember"})
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;


  @GetMapping("/test/hellow")
  public  String test() {

    return  "Hellow World";
  }
  @ApiOperation(value = "회원가입" , response = UsersEntity.class)
  @PostMapping("/user/signUp")
  public ResponseEntity signUp(@RequestBody UserRequest userRequest) {
    return userService.findByUserId(userRequest.getUserId()).isPresent()
        ? ResponseEntity.badRequest().build()
        : ResponseEntity.ok(userService.signUp(userRequest));
  }


  @ApiOperation(value = "로그인" , response = UsersEntity.class)
  @PostMapping("/user/signIn")
  public ResponseEntity<TokenResponse> signIn(@RequestBody UserRequest userRequest) throws Exception {

    return ResponseEntity.ok().body(userService.signIn(userRequest));
  }

  @ApiOperation(value = "회원정보" , response = UsersEntity.class)
  @GetMapping("/info")
  public ResponseEntity<List<UsersEntity>> findUser() {
    return ResponseEntity.ok().body(userService.findUsers());
  }
}
