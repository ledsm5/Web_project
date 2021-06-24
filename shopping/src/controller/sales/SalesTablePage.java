package controller.sales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.SalesDTO;

public class SalesTablePage {
	
	public void salesTable(HttpServletRequest request) {
		String memId = request.getParameter("memId");
		if(memId == "") {
			memId= null;
		}
		SalesDAO dao =new SalesDAO();
		List<SalesDTO> list =dao.salesList(memId);
		request.setAttribute("list", list);
		
	}
}
