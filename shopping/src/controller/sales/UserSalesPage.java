package controller.sales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.SalesDTO;

public class UserSalesPage {
	public void userSales(HttpServletRequest request) {
		String memId = request.getParameter("memId");
		SalesDAO dao = new SalesDAO();
		List<SalesDTO> list = dao.salesList(memId);           //전에 만든 salesList 가져다 다시씀
		request.setAttribute("list", list);
				
	}
}
