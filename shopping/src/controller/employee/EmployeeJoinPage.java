package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeJoinPage {
	public void empInsert(HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setEmpAddress(request.getParameter("empAddress"));
		dto.setEmployeeId(request.getParameter("employeeId"));
		dto.setEmpName(request.getParameter("empName"));
		dto.setEmpPw(request.getParameter("empPw"));
		dto.setEmpUserid(request.getParameter("empUserid"));
		dto.setHireDate(request.getParameter("hireDate"));
		dto.setJobId(request.getParameter("jobId"));
		dto.setOfficeNumber(request.getParameter("officeNumber"));
		dto.setPhNumber(request.getParameter("phNumber"));
		EmployeeDAO dao = new EmployeeDAO();
		dao.empInsert(dto);
	}
}
