package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberDetailPage {
	public void memberDetail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); //오브젝트 타입이기 때문에 형변환 시켜줘야된다.  회원은 자기껏만 봐야되니까 세션에 넣고 세션에서 불러온다 !! 
		String memId = authInfo.getUserId();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memDetail(memId); //지난번에 만든 memDetail 그대로 사용
		request.setAttribute("dto", dto); 
		
	}
}
