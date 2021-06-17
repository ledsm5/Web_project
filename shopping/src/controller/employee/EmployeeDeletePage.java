package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;

public class EmployeeDeletePage {
	public void empDelete(HttpServletRequest request) {
		String empId = request.getParameter("empId");
		EmployeeDAO dao = new EmployeeDAO();
		dao.empDelete(empId);
	}
}
