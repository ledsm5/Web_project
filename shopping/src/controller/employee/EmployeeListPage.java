package controller.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeListPage {
	public void empList(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.getEmpList();
		request.setAttribute("empList", list);
	}
}