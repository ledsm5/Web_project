package controller.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductDTO;

public class GoodsUpdatePage {
	public void goodsUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProductDTO dto = new ProductDTO();
	      dto.setProdCapacity(request.getParameter("prodCapacity"));
	      dto.setProdDelFee(request.getParameter("prodDelFee"));
	      dto.setProdDetail(request.getParameter("prodDetail"));
	      dto.setProdName(request.getParameter("prodName"));
	      dto.setProdNum(request.getParameter("prodNum"));
	      dto.setProdPrice(Integer.parseInt(request.getParameter("prodPrice")));
	      dto.setProdSupplyer(request.getParameter("prodSupplyer"));
	      dto.setRecommend(request.getParameter("recommend"));

		GoodsDAO dao= new GoodsDAO();
		dao.goodsUpdate(dto);
	}
}
