package controller.member;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;


public class MemberModifyPage {   // db로 값 전달하는 페이지 
	public void memUpdate(HttpServletRequest request) {
		
		 try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		  
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(request.getParameter("detailAdd"));
		dto.setMemAccount(request.getParameter("memAccount"));
		dto.setMemAddress(request.getParameter("memAddress"));
		dto.setMemEmail(request.getParameter("memEmail"));
		dto.setMemEmailCk(request.getParameter("memEmailCk"));
		dto.setMemPhone(request.getParameter("memPhone"));
		dto.setPostNumber(request.getParameter("postNumber"));
		dto.setMemId(request.getParameter("memId"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date memBirth = null;
		try {
			memBirth = sf.parse(request.getParameter("memBirth"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setMemBirth(memBirth);
		MemberDAO dao = new MemberDAO(); // 다오로 넘긴다  ==> db 로
		dao.memUpdate(dto); // MemberDAO 에있는 업데이트
	}
}
