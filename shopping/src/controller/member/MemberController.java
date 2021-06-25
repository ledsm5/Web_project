package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet implements Servlet {
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/memAgree.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/agree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memRegist.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memJoin.mem")) {
			MemberJoinPage action = new MemberJoinPage();
			action.memInsert(request);
			response.sendRedirect("main.sm");
		}else if(command.equals("/memList.mem")) {//페이지가 열렸으면 좋겠다.
			//response.setCharacterEncoding("utf-8");  ==> 한글깨질때 넣어주는거   보낼때 깨지면(html에서 깨지면) response   / (콘솔에서깨지면)받을때 깨지면 request
			MemberListPage action = new MemberListPage();
			action.memList(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberList.jsp");  // 리퀘스트를 이용해서 괄호안에 원하는 페이지로 이동하겠다(member 밑에 memberList.jsp
			dispatcher.forward(request, response);
			//dispatcher.include(request,response); 둘중에 뭘로하든 같다! 
		}else if(command.equals("/memInfo.mem")) { //짜른게 이것과 같다면 \
			response.setCharacterEncoding("utf-8");
			MemberInfoPage action = new MemberInfoPage();     
			action.memInfo(request); //request가 값을 가지고있다  / MemberInfoPage 여기에다가 memInfo를 만들어줘야됨 
			// ==> member info 에db값 넣어주는 코드(위에2줄)
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberInfo.jsp"); //dispatcher는 열어주는 친구 
			dispatcher.forward(request, response);
			//쿼리스트링을 날렸다 ==> 그럼그에해당하는걸 디비로 부터 불러와야된다 
		}else if(command.equals("/memMod.mem")) {
			MemberInfoPage action = new MemberInfoPage();     
			action.memInfo(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberModify.jsp"); // ==> 이페이지를 만들어야겠죠 
			dispatcher.forward(request, response); //dispatcher를 통해서  위페이지를 포함시킨다 
		}else if(command.equals("/memModifyOk.mem")) {
			MemberModifyPage action = new MemberModifyPage();
			action.memUpdate(request);
			response.sendRedirect("memList.mem");    //확인하기 
		}else if(command.equals("/memDel.mem")) {
			MemberDeletePage action = new MemberDeletePage();
			action.memDel(request);
			response.sendRedirect("memList.mem");
			
			
			//==========  마이페이지 ================
			
			
			
		}else if(command.equals("/myPage.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memMypage.jsp");
			dispatcher.forward(request, response);		
		}else if(command.equals("/memDetail.mem")) {
			MemberDetailPage action = new MemberDetailPage();
			action.memberDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memSujung.mem")) { // 내가수정할때는 비밀번호를 물어봐야겠지?
			MemberDetailPage action = new MemberDetailPage(); 				// memDetail.mem &  memSujung.mem 이 같은 java페이지를 쓰는이
			action.memberDetail(request);									// 세션의 데이터를 디비로 부터  받아오는게 똑같기 때문 
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/memSujung.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memSujungOk.mem")) {
			MemberUpdatePage action = new MemberUpdatePage();
			int i =action.memberUpdate(request);
			if(i == 1) {
				response.sendRedirect("memDetail.mem");
			}else{
				response.sendRedirect("memSujung.mem");
			}
		}else if(command.equals("/memOut.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/outPw.jsp");  //비밀번호 다시 물어봐야되니까 객체지향하지않고 다시만들어줌
			dispatcher.forward(request, response);
		}else if(command.equals("/memOutOk.mem")) {
			MemberOutPage action = new MemberOutPage();  //리턴받아오려면 필요해 
			int i = action.memOut(request);
			if(i==1) {
				response.sendRedirect("main.sm");     //=> 탈퇴가 되면 메인페이지로 가자 
			}else {
				response.sendRedirect("memOut.mem");
			}
		}else if(command.equals("/memPwChange.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/pwChange.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/pwChangeOk.mem")) {
			MemberPwConfirmPage action = new MemberPwConfirmPage();
			String path =action.pwConFirm(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);		
		}else if(command.equals("/ChangePw.mem")) {
			MemberPwChangePage action =new  MemberPwChangePage();
			int i =action.pwChange(request);
			if(i==1) {
				response.sendRedirect("main.sm");				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/pwChange.jsp");
				dispatcher.forward(request, response);
			}	
//				============  아이디 찾기  ====================
				
				
			
		}else if(command.equals("/idSearch.mem")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/idSearchForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/idSearchCompare.mem")) {
			IdComparePage action =new IdComparePage();
			action.idCompareAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/idCompare.jsp");
			dispatcher.forward(request, response);
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
