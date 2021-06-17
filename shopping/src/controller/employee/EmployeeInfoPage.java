package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeInfoPage {
	public void empInfo(HttpServletRequest request) {
		String empId = request.getParameter("empId");
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.empInfo(empId);
		request.setAttribute("emp",dto );
	}
}
