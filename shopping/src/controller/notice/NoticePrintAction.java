package controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeDAO;
import model.DTO.NoticeDTO;

public class NoticePrintAction {
	
	public void ntcPrint(HttpServletRequest request) {   //디비에서 받아와서 출력하는건 여러행을 출력하니까 리스트로 받아와야된다 
		NoticeDAO dao = new NoticeDAO();				//반면 넣는것은 한 행씩 넣으니까 리스트로 안넣어도된다 
		List<NoticeDTO> list = dao.getNtcPrint();
		request.setAttribute("list2", list);
		
	}
	
}
