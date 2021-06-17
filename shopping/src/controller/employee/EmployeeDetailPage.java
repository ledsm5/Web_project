package controller.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;
import model.DTO.MemberDTO;



public class EmployeeDetailPage {
	public void employeeDetail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.empDetail(empId);
		request.setAttribute("dto", dto);
		

	}
}
