package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class EmployeePwConfirmPage {
	
	public String pwConfirm (HttpServletRequest request) {
		String path = null;
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		if(request.getParameter("empPw").equals(authInfo.getUserPw())) {
			path="employee/empPwChangeOk.jsp";
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀립니다");
			path = "employee/empPwChange.jsp";
		}
		return path;
	}
} 
