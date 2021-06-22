package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.CartDTO;
import model.DTO.OrderList;
import model.DTO.PaymentDTO;
import model.DTO.ProductCartDTO;
import model.DTO.ProductDTO;
import model.DTO.PurchaseDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "PROD_NUM, PROD_NAME,PROD_PRICE,PROD_IMAGE,PROD_DETAIL,PROD_CAPACITY,PROD_SUPPLYER,PROD_DEL_FEE,RECOMMEND,EMPLOYEE_ID,CTGR";
	
	 
	public void payment(PaymentDTO dto) {
		String num = "nvl2(max(payment_appr_num),substr(max(payment_appr_num),-6),100000)+1 "
				+ "from payment "
				+ "where substr(payment_appr_num,1,8) = to_char(sysdate,'yyyymmdd')";
		sql="insert into payment (purchase_num,payment_method,payment_appr_price,payment_appr_num,payment_appr_date,payment_number)"
				+ "values(?,?,?, (" +num + "), sysdate,?) ";
		getConnect();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getPaymentMethod());
			pstmt.setString(3, dto.getPaymentApprPrice());
			pstmt.setString(4, dto.getPaymentNumber());
			int i =pstmt.executeUpdate();
			System.out.println(i+"개가 저장되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	public List<OrderList> orderList(String memId){
	      List<OrderList> list = new ArrayList<OrderList>();
	      sql = "select p2.PURCHASE_DATE, p4.PAYMENT_APPR_NUM , p1.prod_num," 
	         +"       p2.PURCHASE_NUM, p1.prod_name, p1.PROD_SUPPLYER,"  
	         +"       p2.PURCHASE_TOT_PRICE, p1.prod_image " 
	         +" from products p1, purchase p2, purchase_list p3, payment p4 "  
	         +" where p2.PURCHASE_NUM = p3.PURCHASE_NUM "
	         +" and p1.prod_num = p3.prod_num " 
	         +" and p2.PURCHASE_NUM = p4.PURCHASE_NUM(+) "
	         +" and p2.mem_id = ? " 
	         +" order by PURCHASE_NUM desc";
	      getConnect();
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            OrderList dto = new OrderList();
	            dto.setPaymentApprNum(rs.getString("payment_Appr_Num"));
	            dto.setProdImage(rs.getString("prod_Image"));
	            dto.setProdName(rs.getString("prodName"));
	            dto.setProdNum(rs.getString("prodNum"));
	            dto.setProdSupplyer(rs.getString("prod_Supplyer"));
	            dto.setPurchaseDate(rs.getString("purchase_Date"));
	            dto.setPurchaseTotPrice(rs.getNString("purchase_Tot_Price"));
	            dto.setPurchaseNum(rs.getString("purchase_Num"));
	            list.add(dto);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return list;
	   }
	
	
	
	public void cartDel(String prodNum, String memId) {
		sql = "delete from cart "
				+ "where mem_id = ? and prod_num = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, prodNum);
			int i = pstmt.executeUpdate();
			System.out.println(i+ "개가 삭제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void purchaseListInsert(String purchaseNum ,String prodNum, String memId) { //카트와 구매리스트의 차이는 구매번호가 있고 없고 
		sql = "insert into purchase_list(purchase_num,prod_num,PURCHASE_QTY,PURCHASE_PRICE )"
			+ "select ?, prod_num, cart_qty, cart_price"
			+ "from cart"
			+ "where prod_num = ? and mem_id = ?";
		getConnect();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			pstmt.setString(2, prodNum);
			pstmt.setString(3, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 입력되었습니다 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	 
	 
	 public void purchaseInsert(PurchaseDTO dto) {
		 sql ="insert into purchase (PURCHASE_NUM,MEM_ID,PURCHASE_TOT_PRICE, PURCHASE_ADDR,PURCHASE_METHOD,PURCAHSE_REQUEST,RECEIVER_NAME,RECEIVER_PHONE,PURCHASE_DATE)"
		 		+ "values(?,?,?,?,?,?,?,?,sysdate)";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getMemId());
			pstmt.setString(3, dto.getPurchaseTotPrice());
			pstmt.setString(4, dto.getPurchaseAddr());
			pstmt.setString(5, dto.getPurchaseMethod());
			pstmt.setString(6, dto.getPurchaseRequest());
			pstmt.setString(7, dto.getReceiverName());
			pstmt.setString(8, dto.getReceiverPhone());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다");
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			close();
		}
		 
	 }
	 
	 
	 
	public ProductCartDTO prodCart(String prodNum, String memId) {
		ProductCartDTO dto = null;
		sql = "select p.PROD_NUM , PROD_NAME, PROD_PRICE,  PROD_SUPPLYER, PROD_DEL_FEE, prod_image, MEM_ID, CART_QTY, CART_PRICE "
				+ "from products p, cart c"
				+ " where p.PROD_NUM = c.PROD_NUM and MEM_ID = ? and c.PROD_NUM = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, prodNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ProductCartDTO();
				dto.setCartDTO(new CartDTO());
				dto.setProductDTO(new ProductDTO());
				dto.getProductDTO().setProdNum(rs.getString("prod_num"));
				dto.getCartDTO().setCartPrice(rs.getInt("CART_PRICE"));
				dto.getCartDTO().setCartQty(rs.getString("cart_Qty"));
				dto.getProductDTO().setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.getProductDTO().setProdImage(rs.getString("prod_Image"));
				dto.getProductDTO().setProdName(rs.getString("prod_Name"));
				dto.getProductDTO().setProdPrice(rs.getInt("prod_Price"));
				dto.getProductDTO().setProdSupplyer(rs.getString("prod_Supplyer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	 
		public void cartProdDel(CartDTO dto) {
			sql = " delete from cart "
				+ " where MEM_ID = ? and  PROD_NUM = ?";
			getConnect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getMemId());
				pstmt.setString(2, dto.getProdNum());
				int i = pstmt.executeUpdate();
				System.out.println(i+"개가 삭제되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		}
	 
	 public void cartQtyDown(CartDTO dto) {
		 sql = 	  "update cart "
		 		+ "set CART_QTY = CART_QTY - ?"
		 		+ "CART_PRICE = CART_PRICE - ?"
		 		+ "where mem_id =? and prod_num=?";
		 getConnect();
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, dto.getCartPrice());
			pstmt.setString(3, dto.getMemId());
			pstmt.setString(4, dto.getProdNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		 
	 }
	 
	
	 public List cartList(String memId) {
			List list = new ArrayList();
			sql = "select p.PROD_NUM , PROD_SUPPLYER, PROD_DEL_FEE,PROD_IMAGE, PROD_NAME ,PROD_PRICE,CART_PRICE, CART_QTY" 
				+ " from products p, cart c" 
				+ " where p.PROD_NUM = c.prod_num and c.mem_id = ?";
			getConnect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductCartDTO dto = new ProductCartDTO();
					dto.setCartDTO(new CartDTO());
					dto.setProductDTO(new ProductDTO());
					dto.getProductDTO().setProdNum(rs.getString("prod_num"));
					dto.getCartDTO().setCartPrice(rs.getInt("CART_PRICE"));
					dto.getCartDTO().setCartQty(rs.getString("cart_Qty"));
					dto.getProductDTO().setProdDelFee(rs.getString("prod_Del_Fee"));
					dto.getProductDTO().setProdImage(rs.getString("prod_Image"));
					dto.getProductDTO().setProdName(rs.getString("prod_Name"));
					dto.getProductDTO().setProdPrice(rs.getInt("prod_Price"));
					dto.getProductDTO().setProdSupplyer(rs.getString("prod_Supplyer"));
					list.add(dto);				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return list;
		}
	 
	 
	 public void goodsDel(String prodNum) {
		 sql = "delete from products where PROD_NUM = ?";
		 getConnect();
		 try {
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, prodNum);
			 int i = pstmt.executeUpdate();
			 System.out.println(i+"개 행이 삭제되었습니다.");
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 close();
		 }
	 }
	 
	 public void cartInsert(CartDTO dto) {
		 sql = " MERGE INTO CART c USING ( SELECT PROD_NUM FROM PRODUCTS WHERE PROD_NUM = ? ) p "
					+ " ON ( c.PROD_NUM = p.PROD_NUM AND c.MEM_ID = ? ) "
					+ " WHEN MATCHED THEN UPDATE SET CART_QTY = CART_QTY + ? , "
					+ " CART_PRICE = CART_PRICE + ? "
					+ " WHEN NOT MATCHED THEN "
					+ " INSERT (c.MEM_ID, c.PROD_NUM, c.CART_QTY, c.CART_PRICE) " + " VALUES(?, ?, ?, ?) ";
			getConnect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getProdNum());
				pstmt.setString(2, dto.getMemId());
				pstmt.setString(3, dto.getCartQty());
				pstmt.setInt(4, dto.getCartPrice());
				pstmt.setString(5, dto.getMemId());
				pstmt.setString(6, dto.getProdNum());
				pstmt.setString(7, dto.getCartQty());
				pstmt.setInt(8, dto.getCartPrice());
				int i = pstmt.executeUpdate();
				System.out.println(i+"개 행이 저장되었습니다 .");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			

		}
	 
	public void goodsUpdate(ProductDTO dto) {
		sql = " update products "
			+ " set PROD_NAME = ? , PROD_PRICE = ?,"
			+ "     PROD_DETAIL = ?, PROD_CAPACITY= ? , "
			+ "     PROD_SUPPLYER = ? , PROD_DEL_FEE = ?,"
			+ "     RECOMMEND = ?"
			+ " where PROD_NUM = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(8, dto.getProdNum());
			pstmt.setString(1, dto.getProdName());
			pstmt.setInt(2, dto.getProdPrice());
			pstmt.setString(3, dto.getProdDetail());
			pstmt.setString(4, dto.getProdCapacity());
			pstmt.setString(5, dto.getProdSupplyer());
			pstmt.setString(6, dto.getProdDelFee());
			pstmt.setString(7, dto.getRecommend());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public ProductDTO GoodsOne(String prodNum) {
		ProductDTO dto = null;
		sql = "select " + COLUMNS +", "
			+ " case CTGR when 'premierleague' then '프리미어리그' "
			+ "			  when 'laliga' then '라리가' "
			+ "           when 'intenatioal' then '국가대표' "
			+ "			  when 'etc' then '기타' " 
			+ "           end CTGR1 "
			+ " from products "
			+ " where PROD_NUM = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setCtgr(rs.getString("CTGR1"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("prod_Supplyer"));
				dto.setRecommend(rs.getString("recommend"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return dto;
	}
	
	
	
	public List<ProductDTO> goodsList() {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		sql = "select " + COLUMNS +", "
			+ " case CTGR when 'premierleague' then '프리미어리그' "
			+ "			  when 'laliga' then '라리가' "
			+ "           when 'intenatioal' then '국가대표' "
			+ "			  when 'etc' then '기타' " 
			+ "           end CTGR1 "
			+ " from products";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCtgr(rs.getString("CTGR1"));
				dto.setEmployeeId(rs.getString("employee_Id"));
				dto.setProdCapacity(rs.getString("prod_Capacity"));
				dto.setProdDelFee(rs.getString("prod_Del_Fee"));
				dto.setProdDetail(rs.getString("prod_Detail"));
				dto.setProdImage(rs.getString("prod_Image"));
				dto.setProdName(rs.getString("prod_Name"));
				dto.setProdNum(rs.getString("prod_Num"));
				dto.setProdPrice(rs.getInt("prod_Price"));
				dto.setProdSupplyer(rs.getString("prod_Supplyer"));
				dto.setRecommend(rs.getString("recommend"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public void prodInsert(ProductDTO dto) {
			sql = "insert into products (" + COLUMNS + ") values(?,?,?,?,?,?,?,?,?,?,?)";
			getConnect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getProdNum());
				pstmt.setString(2, dto.getProdName());
				pstmt.setInt(3, dto.getProdPrice());
				pstmt.setString(4, dto.getProdImage());
				pstmt.setString(5, dto.getProdDetail());
				pstmt.setString(6, dto.getProdCapacity());
				pstmt.setString(7, dto.getProdSupplyer());
				pstmt.setString(8, dto.getProdDelFee());
				pstmt.setString(9, dto.getRecommend());
				pstmt.setString(10, dto.getEmployeeId());
				pstmt.setString(11, dto.getCtgr());
				int i = pstmt.executeUpdate();
				System.out.println(i + "개행이 추가되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
		}
	
	public String goodsNum() {
		String prodNum = null;
		sql = "select prod_seq.nextval from dual";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			prodNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return prodNum;
	}

		
	
	
}
