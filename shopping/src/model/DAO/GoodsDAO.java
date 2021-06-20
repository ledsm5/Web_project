package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.CartDTO;
import model.DTO.ProductCartDTO;
import model.DTO.ProductDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "PROD_NUM, PROD_NAME,PROD_PRICE,PROD_IMAGE,PROD_DETAIL,PROD_CAPACITY,PROD_SUPPLYER,PROD_DEL_FEE,RECOMMEND,EMPLOYEE_ID,CTGR";
	
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
	 
	 
	
	 public List cartList(String memId) {
			List list = new ArrayList();
			sql = "select p.PROD_NUM , PROD_SUPPLYER, PROD_DEL_FEE,"
				+ "  PROD_IMAGE, PROD_NAME ,PROD_PRICE," 
				+ "        CART_PRICE, CART_QTY" 
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
			}
			return list;
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
			+ " case CTGR when 'wear' then '의류' "
			+ "			  when 'entertainer' then '연예인' "
			+ "           when 'food' then '음식' "
			+ "			  when 'bj' then 'bj' " 
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
