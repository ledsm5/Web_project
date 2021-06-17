package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductDTO;

public class GoodsModifyPage {
	public void goodsModify(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		GoodsDAO dao = new GoodsDAO();
		ProductDTO dto = dao.GoodsOne(prodNum);
		request.setAttribute("dto", dto);
	}
}
