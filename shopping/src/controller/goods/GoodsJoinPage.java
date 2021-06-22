package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsJoinPage {
	public void goodsJoin(HttpServletRequest request) {
		String filePath = "goods/upload";
		String realPath = request.getServletContext()
								 .getRealPath("goods/upload");
		System.out.println(realPath);
		int fileSize = 1024*1024*5;
		MultipartRequest multi = null;
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		String emp_no = authInfo.getGrade();
		String storeFileName1;
		String storeFileName2;
		String storeFileName3;
		String images="";
		try {
			// MultipartRequest가 실행이될 때 파일 저장
			multi =	new MultipartRequest(request, realPath, fileSize,"utf-8",new DefaultFileRenamePolicy());
			// 저장된 파일명 가져오기
			storeFileName1 = multi.getFilesystemName("prodImage1");
			storeFileName2 = multi.getFilesystemName("prodImage2");
			storeFileName3 = multi.getFilesystemName("prodImage3");
			// 저장된 파일명 연결
			images = storeFileName1+","+storeFileName2+","+storeFileName3;
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProductDTO dto = new ProductDTO();
		dto.setEmployeeId(emp_no);
		dto.setProdCapacity(multi.getParameter("prodCapacity"));
		dto.setProdDelFee(multi.getParameter("prodDelFee"));
		dto.setProdDetail(multi.getParameter("prodDetail"));
		/// 연결된 파일명을 dto에 저장
		dto.setProdImage(images);
		dto.setProdName(multi.getParameter("prodName"));
		dto.setProdNum(multi.getParameter("goodsNum"));
		dto.setProdPrice(Integer.parseInt(multi.getParameter("prodPrice")));
		dto.setProdSupplyer(multi.getParameter("prodSupplyer"));
		dto.setRecommend(multi.getParameter("recommend"));
		dto.setCtgr(multi.getParameter("ctgr"));
		GoodsDAO dao = new GoodsDAO();
		dao.prodInsert(dto);
	}
}
