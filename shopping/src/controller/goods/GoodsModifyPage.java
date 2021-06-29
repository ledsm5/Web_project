package controller.goods;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProdReviewDTO;
import model.DTO.ProductDTO;

public class GoodsModifyPage {
	public void goodsModify(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String prodNum = request.getParameter("prodNum");
		GoodsDAO dao = new GoodsDAO();
		ProductDTO dto = dao.GoodsOne(prodNum);
		List<ProdReviewDTO> list= dao.prodReviewSelect(prodNum); 
		request.setAttribute("list", list);
		request.setAttribute("dto", dto);
	}
}
