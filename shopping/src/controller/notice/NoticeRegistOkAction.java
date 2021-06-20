package controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.NoticeDAO;
import model.DTO.AuthInfo;
import model.DTO.NoticeDTO;

public class NoticeRegistOkAction {
	
	public void ntcRegistOK(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getGrade();
		
		NoticeDTO dto = new NoticeDTO();
		dto.setEmployeeId(empId);
		dto.setNoticeCon(request.getParameter("noticeCon"));
		dto.setNoticeCount(request.getParameter("noticeCount"));
		dto.setNoticeDate(request.getParameter("noticeDate"));
		dto.setNoticeFile(request.getParameter("noticeFile"));
		dto.setNoticeNo(request.getParameter("noticeNo"));
		dto.setNoticeSub(request.getParameter("noticeSub"));
		
		NoticeDAO dao = new NoticeDAO();
		dao.noticeInsert(dto);
	}
}
