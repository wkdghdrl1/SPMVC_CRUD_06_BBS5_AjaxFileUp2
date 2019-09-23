package com.biz.bbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.bbs.model.MemberVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		/*
		 * login등 처리를 하기위해서는
		 * HttpSession 클래스를 사용해야 하는데
		 *  Controller에서 처럼 매개변수로 처리야하 사용하는 것이 불가능
		 *  request의 getSession() 매소드를 사용하여 session정보를 추출
		 */ 
		HttpSession httpSession = request.getSession();
		MemberVO memberVO = (MemberVO) httpSession.getAttribute("LOGIN");
		if(memberVO == null) {
			
			response.sendRedirect("/bbs/member/login?LOGIN_MSG=LOGIN");
			
			// Controller로 제어권을 전달하지 않고 종료 
			return false;
		}
		
		// 어디서 불렀는지 확인
		// /bbs/write
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();
		
		log.debug("URL : " + url);
		log.debug("URI : " + uri);
		
		// controller로 제어권 전달
		return super.preHandle(request, response, handler);
	}
	
	
	
	
}
