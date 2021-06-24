package controller.sales;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.DeliveryDTO;

public class CreateDeliveryPage {

		
	
	public void execute(HttpServletRequest request) {
	
		SalesDAO dao = new SalesDAO();
		DeliveryDTO dto = dao.deliverySelect(request.getParameter("purchaseNum"));
		request.setAttribute("purchaseNum", request.getParameter("purchaseNum"));
		request.setAttribute("dto", dto);
	}
}
