package controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

public class NoticeController extends  HttpServlet implements Servlet{
	public void doProcess(HttpServletRequest request , HttpServletResponse response) throws ServletException ,IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		if(command.equals("/noticeMain.nt")) {
			NoticePrintAction action = new NoticePrintAction();
			action.ntcPrint(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice/ntcList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/noticeRegist.nt")) {
			NoticeRegistAction action =new NoticeRegistAction();
			action.ntcRegist(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice/noticeRegist.jsp");
			dispatcher.forward(request, response);		
		}else if(command.equals("/noticeRegistOk.nt")) {
			NoticeRegistOkAction action = new NoticeRegistOkAction();
			action.ntcRegistOK(request);
			response.sendRedirect("noticeMain.nt");
		}else if(command.equals("/noticeDetail.nt")) {
			NoticeDetailPrintPage action = new NoticeDetailPrintPage();
			action.detailPrint(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice/ntcDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/noticeDelete.nt")) {
			NoticeDeletePage action = new NoticeDeletePage();
			action.noticeDeleteAction(request);
			response.sendRedirect("noticeMain.nt");
		}else if(command.equals("/noticeModifyForm.nt")) {
			NoticeDetailPrintPage action = new NoticeDetailPrintPage();
			action.detailPrint(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("notice/ntcModify.jsp");
			dispatcher.forward(request, response);			
		}else if(command.equals("/noticeModify.nt")) {
			NoticeModifyPage action = new NoticeModifyPage();
			action.noitceModifyAction(request);
			response.sendRedirect("noticeMain.nt");
		}
	
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
