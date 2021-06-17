package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;

public class MemberOutPage {
	public int memOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(request.getParameter("memPw").equals(authInfo.getUserPw())) {
			MemberDAO dao =new MemberDAO();
			dao.memDel(authInfo.getUserId());
			session.invalidate(); // 탈퇴하고나서  세션을 없앤다 !   remove는 속성만 없애는 것이고  invalidate는 세션 자체를 없애는 것이다 
			return 1;
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀렸어요~");   //이걸 다시 outPw로 보내서 <span>${pwFail }</span> 넣어줘야 메시지가 출력된다 
			return 2;
		}
		
	}
}
