package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.member.MemberDetailPage;

public class EmployeeController extends HttpServlet implements Servlet{
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		if(command.equals("/empList.em")) {
			EmployeeListPage action = new EmployeeListPage();
			action.empList(request);
			RequestDispatcher dispatcher =request.getRequestDispatcher("employee/employeeList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empRegest.em")) {
			EmployeeNumPage action = new EmployeeNumPage();
			action.getNum(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empJoin.em")) {
			EmployeeJoinPage action = new EmployeeJoinPage();
			action.empInsert(request);
			response.sendRedirect("empList.em");
		}else if(command.equals("/empInfo.em")) {
			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher =request.getRequestDispatcher("employee/employeeInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModify.em")) {
			EmployeeInfoPage action = new EmployeeInfoPage();
			action.empInfo(request);
			RequestDispatcher dispatcher =request.getRequestDispatcher("employee/employeeModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModifyOk.em")) {
			EmployeeModifyPage action = new EmployeeModifyPage();
			action.empModify(request);
			response.sendRedirect("empList.em");
		}else if(command.equals("/empDelete.em")) {
			EmployeeDeletePage action = new EmployeeDeletePage();
			action.empDelete(request);
			response.sendRedirect("empList.em");
			
			
		// 	==============  직원 마이페이지  =============== 
			
			
		}else if(command.equals("/myPage.em")) {
 			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empUpdate.em")) {
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.employeeDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empUpdateOk.em")) {
			EmployeeUpdatePage action = new EmployeeUpdatePage();
			action.employeeUpdate(request);
			int i =action.employeeUpdate(request);
			if(i==1) {
				response.sendRedirect("/myPage.em");
			}else {
				response.sendRedirect("/empUpdate.em");
			}
		}else if(command.equals("/empPwChange.em")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empPwChange.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empPwChangeOk.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empPwChangeOk.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
