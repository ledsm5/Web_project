package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberInfoPage {
	public void memInfo(HttpServletRequest request) {
		String memId = request.getParameter("memId"); //request로부터 날라온 memId
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memDetail(memId); //다오 에다가 memId를 넘겨준다 
		request.setAttribute("dto", dto);
		
		
	}
}
