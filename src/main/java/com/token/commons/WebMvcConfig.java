package com.token.commons;

import com.token.commons.Jwt.JwtTokenInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
  private final JwtTokenInterceptor jwtTokenInterceptor;

  public void addInterceptors(InterceptorRegistry registry) {
    log.info("인터셉터 등록");
    registry.addInterceptor(jwtTokenInterceptor).addPathPatterns("/info");
  }
}
