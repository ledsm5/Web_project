package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.NoticeDTO;

public class NoticeDAO extends DataBaseInfo {
	final String COLUMNS ="NOTICE_NO , NOTICE_SUB, NOTICE_CON,NOTICE_DATE ,NOTICE_KIND,NOTICE_FILE, NOTICE_COUNT,EMPLOYEE_ID  ";
	
	
	
		
	
	
	public void noticeModify(NoticeDTO dto) {
		sql = " update notice set NOTICE_SUB = ? , NOTICE_CON= ? ,NOTICE_FILE=? "
				+ " where notice_no = ? ";
		getConnect();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNoticeSub());
			pstmt.setString(2, dto.getNoticeCon());
			pstmt.setString(3, dto.getNoticeFile());
			pstmt.setString(4, dto.getNoticeNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	public void noticeDelete(String noticeNo) {
		sql = "delete from notice where notice_no = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNo);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 삭제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	
	
	public void noticeInsert(NoticeDTO dto) {
		sql = "insert into notice(NOTICE_NO , NOTICE_SUB, NOTICE_CON,NOTICE_DATE ,NOTICE_FILE, NOTICE_COUNT,EMPLOYEE_ID)" + "values(?,?,?,?,?,?,?)";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNoticeNo());
			pstmt.setString(2, dto.getNoticeSub());
			pstmt.setString(3, dto.getNoticeCon());
			pstmt.setString(4, dto.getNoticeDate());
			pstmt.setString(5, dto.getNoticeFile());
			pstmt.setString(6, dto.getNoticeCount());
			pstmt.setString(7, dto.getEmployeeId());
			
			int i = pstmt.executeUpdate();
			System.out.println( i + "개행이 저장되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	
	
	public int getNoticeNo() {
		sql = "select nvl(max(NOTICE_NO),0) +1 from notice";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	
	public NoticeDTO detailPrint(String noticeNo) {
		NoticeDTO dto = new NoticeDTO();
		sql= "select NOTICE_NO,EMPLOYEE_ID,NOTICE_SUB,NOTICE_DATE,NOTICE_CON,NOTICE_FILE from notice where NOTICE_NO = ? " ;
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNo);
			rs = pstmt.executeQuery();
			System.out.println(rs.getRow());
			
			if(rs.next()) {
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setNoticeCon(rs.getString("NOTICE_CON"));
				dto.setNoticeDate(rs.getString("NOTICE_DATE"));
				dto.setNoticeFile(rs.getString("NOTICE_FILE"));
				dto.setNoticeNo(rs.getString("notice_No"));
				dto.setNoticeSub(rs.getString("NOTICE_SUB"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	
	public List<NoticeDTO> getNtcPrint() {
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		sql="SELECT " +COLUMNS+ "from notice ";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				NoticeDTO dto = new NoticeDTO();
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setNoticeCon(rs.getString("NOTICE_CON"));
				dto.setNoticeCount(rs.getString("NOTICE_COUNT"));
				dto.setNoticeDate(rs.getString("NOTICE_DATE"));
				dto.setNoticeFile(rs.getString("NOTICE_FILE"));
				dto.setNoticeKind(rs.getString("NOTICE_KIND"));
				dto.setNoticeNo(rs.getString("NOTICE_NO"));
				dto.setNoticeSub(rs.getString("NOTICE_SUB"));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
}
