package controller.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.NoticeDAO;
import model.DTO.NoticeDTO;

public class NoticeModifyPage {
	public void noitceModifyAction(HttpServletRequest request) {
		String filePath ="notice/upload";
		String realPath =request.getServletContext().getRealPath(filePath);
		
		int fileSize = 1024*1024*5;
		MultipartRequest multi =null;
		
		String storeFileName;
		String images="";
		try {
			multi = new MultipartRequest(request, realPath,fileSize,"utf-8", new DefaultFileRenamePolicy());
			storeFileName= multi.getFilesystemName("noticeFile");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		NoticeDTO dto = new NoticeDTO();

		dto.setNoticeCon(multi.getParameter("noticeCon"));
		dto.setNoticeNo(multi.getParameter("noticeNo"));
		dto.setNoticeSub(multi.getParameter("noticeSub"));
		dto.setNoticeFile(images);
		NoticeDAO dao = new NoticeDAO();
		dao.noticeModify(dto);
	}
}
