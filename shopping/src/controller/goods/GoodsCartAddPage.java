package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.CartDTO;

public class GoodsCartAddPage {
	public void cartAdd(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		String cartQty = request.getParameter("qty");
		String prodPrice = request.getParameter("prodPrice");
		
		Integer cartPrice = (Integer.parseInt(cartQty) * Integer.parseInt(prodPrice));
		HttpSession session = request.getSession();
		AuthInfo authInfo =(AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setCartPrice(cartPrice);
		dto.setCartQty(cartQty);
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		
		GoodsDAO dao = new GoodsDAO();
		dao.cartInsert(dto);
		
	}
}
