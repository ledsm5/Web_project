package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PaymentDTO;

public class PaymentPage {
	public void payment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		PaymentDTO dto = new PaymentDTO();
		dto.setMemId(memId);
		dto.setPaymentApprPrice(request.getParameter("paymentApprPrice"));
		dto.setPaymentMethod("카드");
		dto.setPaymentNumber(request.getParameter("paymentNumber"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		GoodsDAO dao = new GoodsDAO();
		dao.payment(dto);
		request.setAttribute("money",dto.getPaymentApprPrice() );
	}
}	
