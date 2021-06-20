package controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeDAO;
import model.DTO.NoticeDTO;

public class NoticePrintAction {
	
	public void ntcPrint(HttpServletRequest request) {
		NoticeDAO dao = new NoticeDAO();
		List<NoticeDTO> list = dao.getNtcPrint();
		request.setAttribute("lists", list);
		
	}
	
}
