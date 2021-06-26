package controller.notice;

import javax.servlet.http.HttpServletRequest;
import model.DAO.NoticeDAO;
import model.DTO.NoticeDTO;

public class NoticeDetailPrintPage {
	public void detailPrint(HttpServletRequest request) {
		
		String noticeNo = request.getParameter("noticeNo");
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.detailPrint(noticeNo);
		request.setAttribute("dto", dto);
	}
}
