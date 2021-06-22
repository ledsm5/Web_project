package controller.goods;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PurchaseDTO;

public class GoodsOrderPage {
	public String goodsOrderAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		
		Date day =new Date(); SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String purchaseNum = df.format(day);
		
		 
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseNum(purchaseNum); 
		dto.setPurchaseTotPrice(request.getParameter("purchaseTotPrice"));
		dto.setMemId(memId);
		dto.setPurchaseAddr(request.getParameter("purchaseAddr"));
		dto.setPurchaseMethod(request.getParameter("purchaseMethod"));
		dto.setPurchaseRequest(request.getParameter("purchaseRequest"));
		dto.setReceiverName(request.getParameter("receiverName"));
		dto.setReceiverPhone(request.getParameter("receiverPhone"));
		GoodsDAO dao = new GoodsDAO();
		dao.purchaseInsert(dto);
		
		
		String [] prodNums= request.getParameter("prodNums").split(",");
		for(String prodNum : prodNums) {    				//in을 jsp에서 못쓰니까 for 문으로 돌림 
			dao.purchaseListInsert(purchaseNum,prodNum,memId);
		}
		for(String prodNum: prodNums) {
			dao.cartDel(prodNum,memId);
		}
		return purchaseNum + "," + dto.getPurchaseTotPrice();
	}
}
