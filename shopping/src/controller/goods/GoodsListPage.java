package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductDTO;

public class GoodsListPage {
	public void goodsList(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<ProductDTO> list = dao.goodsList();
		request.setAttribute("lists", list);
	}
}
