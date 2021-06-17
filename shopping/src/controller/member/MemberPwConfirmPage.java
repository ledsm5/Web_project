package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class MemberPwConfirmPage {
	public String pwConFirm(HttpServletRequest request) {
		String path = null;
		HttpSession session = request.getSession();//비밀번호가 session에있기때문에 session에서 불럿와서 비교한다 
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(request.getParameter("memPw").equals(authInfo.getUserPw())) {
			path = "member/pwChangeOk.jsp";
			session.removeAttribute("pwFail1");
		}else {
//			session.setAttribute("pwFail1", "비밀번호가 틀립니다"); 새로만들어주는 구문  //여기는 바로 jsp로 보내기때문에 session을 줄필요가없다  ==>request로   //로그인하면 다 로그인 되어있는 기능 
			request.setAttribute("pwFail1", "비밀번호가 다릅니다"); //리퀘스트는 현재페이지에서만 하니까 지울필요가없다 
			path="member/pwChange.jsp";
		}
			
		return path;
	}
}
