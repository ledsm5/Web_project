package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;

public class EmployeeNumPage {
	public void getNum(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		int empNo = dao.getEmpNo();
		request.setAttribute("empNo", empNo);
	}
}
