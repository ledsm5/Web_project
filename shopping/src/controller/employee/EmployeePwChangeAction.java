package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;

public class EmployeePwChangeAction {
	
	public int pwChangeAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		String userid = authInfo.getUserId();
		String empPw = request.getParameter("newPw");
		
		if(request.getParameter("empPw").equals(authInfo.getUserPw())) {
			EmployeeDAO dao = new EmployeeDAO();
			dao.empPwChange(userid, empPw);
			return 1;
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀립니다");
			return 2;
		}
	}
}
