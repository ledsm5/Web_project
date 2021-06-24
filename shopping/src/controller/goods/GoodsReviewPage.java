package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.ProductReviewDTO;

public class GoodsReviewPage {
	public void review(HttpServletRequest request) {
		String path = "goods/review";
		String realPath = request.getServletContext().getRealPath(path);
		int size = 1024 * 1024 *5;
		MultipartRequest multi = null;
		ProductReviewDTO dto = new ProductReviewDTO();
		try {
			multi = new MultipartRequest(request, realPath, size, "utf-8" , new DefaultFileRenamePolicy());
	
			dto.setProdNum(multi.getParameter("prodNum"));
			dto.setPurchaseNum(multi.getParameter("purchaseNum"));
			dto.setReviewContent(multi.getParameter("reviewContent"));
			dto.setReviewImg(multi.getFilesystemName("reviewImg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GoodsDAO dao = new GoodsDAO();
		dao.reviewInsert(dto);
		
		
		
	}
}


   