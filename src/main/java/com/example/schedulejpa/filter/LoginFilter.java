package com.example.schedulejpa.filter;

import com.example.schedulejpa.common.Const;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

@Slf4j
public class LoginFilter implements Filter {

  private static final String[] WHITE_LIST = {"/members/signup", "/login"};


  @Override
  public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain chain
  ) throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    String requestURI = httpRequest.getRequestURI();

    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

    log.info("로그인 필터 로직 실행");

    if(!isWhiteList(requestURI)){
      HttpSession session = httpRequest.getSession(false);

      if(session == null || session.getAttribute(Const.LOGIN_USER) == null){
        throw new RuntimeException("로그인 해주세요.");
      }

    }

    chain.doFilter(servletRequest,servletResponse);

  }

  private boolean isWhiteList(String requestURI){
    return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);

  }
}


