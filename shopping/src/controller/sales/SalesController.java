package controller.sales;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class SalesController  extends  HttpServlet implements Servlet{
	public void doProcess(HttpServletRequest request , HttpServletResponse response) throws ServletException ,IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());	
		
		
		if(command.equals("/salesTable.sl")) {
			SalesTablePage action = new SalesTablePage();
			action.salesTable(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/salesTable.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userSales.sl")) {
			UserSalesPage action = new UserSalesPage();
			action.userSales(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/userSales.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/customerTotal.sl")) {
			CustomerTotalPage action = new CustomerTotalPage();
			action.customerTotalAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/customerTotal.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/createDelivery.sl")) {
			CreateDeliveryPage action = new CreateDeliveryPage();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("sales/deliveryForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/deliveryConfirm.sl")) {
			DeliveryConfirmPage action = new DeliveryConfirmPage();
			action.deliveryConfirmAction(request);
			response.sendRedirect("salesTable.sl");
			
		}
	}
	
	
	
	
	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doProcess(req, resp);	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doProcess(req, resp);
	}
}
