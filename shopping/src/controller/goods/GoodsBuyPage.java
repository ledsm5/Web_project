package controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductCartDTO;

public class GoodsBuyPage {
	public void goodsBuyAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		String [] prodNums = request.getParameterValues("prodCk"); // 배열은 values로 받는다.
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>(); //in연산자를 사용 할수 없어서 List 로 만든다
		GoodsDAO dao = new GoodsDAO();
		for(String prodNum : prodNums) {
			ProductCartDTO dto = dao.prodCart(prodNum,memId);
			list.add(dto);
		}
		request.setAttribute("list", list);
		//where p.prod_num = c.prod_num and mem_id =123 and p.prod_num in(100086,100087); 이거를
		
		//where p.prod_num = c.prod_num and mem_id =123 and p.prod_num =100086
		//where p.prod_num = c.prod_num and mem_id =123 and p.prod_num =100087   이렇게 두개를 반복문으로 써주겠다 
 	}
}
