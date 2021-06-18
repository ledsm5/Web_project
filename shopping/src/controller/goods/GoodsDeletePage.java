package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductDTO;

public class GoodsDeletePage {
	public void prodDelete(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		GoodsDAO dao = new GoodsDAO();
		
		//디비에서만 삭제하는게 아니라 파일자체를 찾아서 삭제하려는 코드!
		ProductDTO dto = dao.GoodsOne(prodNum);
		String filePath = "goods/upload";
		String realPath = request.getServletContext().getRealPath(filePath);
		String [] fileNames = dto.getProdImage().split(",");
		if(fileNames.length > 0) {
			for(String fileName : fileNames) {
				String path = realPath + "/" + fileName;
				File f = new File(path);
				if(f.exists()) f.delete();
			}
		}
		dao.goodsDel(prodNum);
	}
}
