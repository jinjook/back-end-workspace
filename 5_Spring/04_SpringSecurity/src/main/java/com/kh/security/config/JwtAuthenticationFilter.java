package com.kh.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kh.security.model.vo.Member;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private TokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		System.out.println("jwt Filter!");
		
		// 클라이언트에서 보낸 토큰을 받아서 사용자 확인 후 인증 처리 
		String token = parseBearerToken(request);
//		System.out.println(token);
		
		if(token!=null && !token.equalsIgnoreCase("null")) {
			// 토큰이 있을때
			Member member = tokenProvider.validate(token);
//			System.out.println(member); // member 정보가 받아지는지 확인
			
			// 추출된 인증 정보를 필터링에서 사용할 수 있도록 SecurityContext에 등록
			// 인증 관련
			AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member, member.getPassword(), member.getAuthorities()); // member.getAuthorities() 권한 관련
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			// 등록
			SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
			securityContext.setAuthentication(authentication);
			
			SecurityContextHolder.setContext(securityContext);
		}
		
		filterChain.doFilter(request, response);
	}

	private String parseBearerToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7); // 7번째 글자부터 ('Bearer'+token 로 해뒀으니까)
		}
		return null;
	}
	
	
}
