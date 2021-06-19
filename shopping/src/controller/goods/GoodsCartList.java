package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;

public class GoodsCartList {
	public void cartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		GoodsDAO dao = new GoodsDAO();
		List list = dao.cartList(memId); 
		request.setAttribute("lists", list);	
	}
}
