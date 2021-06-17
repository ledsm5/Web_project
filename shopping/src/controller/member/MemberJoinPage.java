package controller.member;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;


public class MemberJoinPage {
	public void memInsert(HttpServletRequest request) {
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
		dto.setMemGender(request.getParameter("memGender"));
		dto.setMemId(request.getParameter("memId"));
		dto.setMemName(request.getParameter("memName"));
		dto.setMemPhone(request.getParameter("memPhone"));
		dto.setMemPw(request.getParameter("memPw"));
		dto.setPostNumber(request.getParameter("postNumber"));
		String birth = request.getParameter("memBirth"); 
		/// 날짜 형식 지정
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date memBirth = null;
		try {
			memBirth = sf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setMemBirth(memBirth);
		MemberDAO dao = new MemberDAO();
		dao.memInsert(dto);	
	}
}
