package controller.notice;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeDAO;

public class NoticeDeletePage {
	public void noticeDeleteAction(HttpServletRequest request) {
		String noticeNo = request.getParameter("noticeNo");
		NoticeDAO dao = new NoticeDAO();
		dao.noticeDelete(noticeNo);
	}
}
