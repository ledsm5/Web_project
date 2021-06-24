package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductReviewDTO;

public class GoodsReviewInfoPage {
	public void reviewInfo(HttpServletRequest request) {
		ProductReviewDTO dto = new ProductReviewDTO();
		dto.setProdNum(request.getParameter("prodNum"));
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		GoodsDAO dao = new GoodsDAO();
		dao.reviewSelect(dto);
		request.setAttribute("dto", dto);
		
	}
}
