package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberListPage {
	public void memList(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.memList(); //멤버 리스트를 통해서 dao를 가져오겠다
		request.setAttribute("lists", list); //lists라고해서 list에 저장하겠다 
	}
}      
