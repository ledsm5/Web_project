package controller.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.NoticeDAO;
import model.DTO.AuthInfo;
import model.DTO.NoticeDTO;

public class NoticeRegistOkAction {
	
	public void ntcRegistOK(HttpServletRequest request) {
		String filePath = "notice/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		
		int fileSize = 1024*1024*5;
		MultipartRequest multi = null;
	
;
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		
		String storeFileName;
		String images="";
		
		try {
			multi = new MultipartRequest(request,realPath,fileSize,"utf-8",new DefaultFileRenamePolicy());
			storeFileName = multi.getFilesystemName("noticeFile");
			images = storeFileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		NoticeDTO dto = new NoticeDTO();
		dto.setEmployeeId(empId);
		dto.setNoticeCon(multi.getParameter("noticeCon"));
		dto.setNoticeCount(multi.getParameter("noticeCount"));
		dto.setNoticeDate(multi.getParameter("noticeDate"));
		dto.setNoticeFile(multi.getParameter("noticeFile"));
		dto.setNoticeNo(multi.getParameter("noticeNo"));
		dto.setNoticeSub(multi.getParameter("noticeSub"));
		dto.setNoticeFile(images);
		NoticeDAO dao = new NoticeDAO();
		dao.noticeInsert(dto);
	}
}
