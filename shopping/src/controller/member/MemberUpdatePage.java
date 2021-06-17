package controller.member;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class MemberUpdatePage {
	public Integer memberUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("AuthInfo");
		MemberDTO dto = new MemberDTO();
			dto.setDetailAdd(request.getParameter("detailAdd"));
			dto.setMemAccount(request.getParameter("memAccount"));
			dto.setMemAddress(request.getParameter("memAddress"));
			dto.setMemEmail(request.getParameter("memEmail"));
			dto.setMemEmailCk(request.getParameter("memEmailCk"));
			dto.setMemPhone(request.getParameter("memPhone"));
			dto.setPostNumber(request.getParameter("postNumber"));
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date memBirth = null;
			try {
				memBirth = sf.parse(request.getParameter("memBirth"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dto.setMemBirth(memBirth);
			dto.setMemPw(request.getParameter("memPw"));
			dto.setMemId(authInfo.getUserId());
			if(request.getParameter("memPw").equals(authInfo.getUserPw())) {
				MemberDAO dao = new MemberDAO();
				dao.memUpdate(dto);
				session.removeAttribute("pwFail");
				return 1;
			}else {
				session.setAttribute("pwFail", "비밀번호가 틀렸습니다 ");
				return 2;
			}
				
			
			
	}
}
