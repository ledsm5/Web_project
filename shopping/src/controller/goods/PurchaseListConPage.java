package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.OrderList;

public class PurchaseListConPage {
	public void purchaseListAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId= authInfo.getUserId();
		GoodsDAO dao = new GoodsDAO();
		List<OrderList> list = dao.orderList(memId);
		request.setAttribute("list", list);
		
	}
}
