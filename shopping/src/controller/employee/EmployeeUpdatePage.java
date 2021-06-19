package controller.employee;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class EmployeeUpdatePage {
		public Integer employeeUpdate(HttpServletRequest request) {
			HttpSession session = request.getSession();
			AuthInfo authInfo = (AuthInfo)session.getAttribute("AuthInfo");
			EmployeeDTO dto = new EmployeeDTO();
				dto.setHireDate(request.getParameter("hireDate"));
				dto.setJobId(request.getParameter("jobId"));
				dto.setPhNumber(request.getParameter("phNumber"));
				dto.setEmail(request.getParameter("email"));
				dto.setEmpAddress(request.getParameter("empAddress"));
				dto.setEmpPw(request.getParameter("empPw"));
				dto.setEmpUserid(authInfo.getUserId());		
				if(request.getParameter("empPw").equals(authInfo.getUserPw())) {
					EmployeeDAO dao = new EmployeeDAO();
					dao.empMod(dto);
					session.removeAttribute("pwFail");
					return 1;
				}else {
					session.setAttribute("pwFail", "비밀번호가 틀렸습니다");
					return 2;
				}
				
		}
}
