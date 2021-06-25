package controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginPage {
	public void login(HttpServletRequest request , HttpServletResponse response) { //request를 받아온다 
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.login(userId);
		if(authInfo ==null) {
			session.removeAttribute("pwFail");
			session.setAttribute("userFail", "아이디 정보가 없습니다 ");
		}else{
			session.removeAttribute("userFail");
			if(userPw.equals(authInfo.getUserPw())) {
				session.removeAttribute("pwFail");
				session.setAttribute("authInfo",authInfo);    // authInfo = 로그인정보     //session은 페이지가 닫힐때까지 사용가능하기 때문에 다시 만들지 않아도됨 
			
				
				//자동로그인 
				String autologin = request.getParameter("autologin");
				if(autologin != null && autologin.equals("auto")) {
					Cookie cookie = new Cookie("autoLogin",userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				//웹브라우저를 닫기전까지 사용할수 있도록 session에 저장 
				//쿠키를 만ㄷ르어 달라고 요청
				String idStore =request.getParameter("idStore");
				if(idStore != null && idStore.equals("store")) {
					//쿠키 생성 
					Cookie cookie = new Cookie("idStore",userId);
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					//웹브라우저에  쿠키를  전달 
					response.addCookie(cookie);
				}else{
					//쿠키 0시간으로 바꿔서 삭제 
					Cookie cookie = new Cookie("idStore",userId);
					cookie.setPath("/");
					cookie.setMaxAge(0);
					//웹브라우저에  쿠키를  전달 
					response.addCookie(cookie);
				}
			}else {
				session.setAttribute("pwFail", "비밀번호가 틀렸습니다");
			}
		}
		
	}
}
