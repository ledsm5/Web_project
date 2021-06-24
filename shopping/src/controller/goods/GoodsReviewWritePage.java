package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductReviewDTO;

public class GoodsReviewWritePage {
	public void reviewUpadte(HttpServletRequest request) {
		ProductReviewDTO dto = new ProductReviewDTO();
		dto.setProdNum(request.getParameter("prodNum"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		dto.setReviewContent(request.getParameter("reviewContent"));
		
		GoodsDAO dao = new GoodsDAO();
		dao.reviewUpdate(dto);
		
	}
}
