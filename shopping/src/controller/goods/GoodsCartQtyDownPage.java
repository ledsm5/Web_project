package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.CartDTO;

public class GoodsCartQtyDownPage {
	
	public void cartQtyDown(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		String prodPrice = request.getParameter("prodPrice");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setMemId(memId);
		dto.setCartQty("1");
		dto.setCartPrice(Integer.parseInt(prodPrice));
		dto.setProdNum(prodNum);
		GoodsDAO dao = new GoodsDAO();
		dao.cartQtyDown(dto);
	}
}
