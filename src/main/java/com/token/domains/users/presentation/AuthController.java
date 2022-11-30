package com.token.domains.users.presentation;

import com.token.domains.users.application.AuthService;
import com.token.domains.users.application.dto.TokenResponse;
import com.token.domains.users.application.dto.UserRequest;
import com.token.domains.users.domain.UsersEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@RestController
@Api(tags = {"JoinMember"})
@RequiredArgsConstructor
public class AuthController {

  private final AuthService userService;


  @ApiOperation(value = "회원가입" , response = UsersEntity.class)
  @PostMapping("/signUp")
  public ResponseEntity signUp(@RequestBody UserRequest userRequest) {
    return userService.findByUserId(userRequest.getUserId()).isPresent()
        ? ResponseEntity.badRequest().build()
        : ResponseEntity.ok(userService.signUp(userRequest));
  }


  @ApiOperation(value = "로그인" , response = UsersEntity.class)
  @PostMapping("/login")
  public ResponseEntity<TokenResponse> signIn(@RequestBody UserRequest userRequest) throws Exception {

    return ResponseEntity.ok().body(userService.signIn(userRequest));
  }





}
