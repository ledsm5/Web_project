package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;

public class MemberDAO {
	final String COLUMNS = " MEM_ID,MEM_PW,POST_NUMBER,MEM_ADDRESS,"
			+ "DETAIL_ADD,MEM_NAME, MEM_PHONE,MEM_BIRTH,MEM_GENDER,"
			+ "MEM_ACCOUNT,MEM_EMAIL,MEM_EMAIL_CK ";
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	String sql;
	PreparedStatement pstmt; //sql 결과값을 실행
	ResultSet rs;				// 종료
	Integer result;
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public static void getConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl,"board","oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void pwChange(String memId, String memPw) {
		sql = "update member set mem_pw=? where mem_id = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memPw);
			pstmt.setString(2, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	public void memDel(String memId){
		sql = "delete from member where mem_id =?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void memUpdate(MemberDTO dto) {  //MemberModifyPage 에서 dao로 보내는
		sql = "update member set POST_NUMBER=?,MEM_ADDRESS=?,DETAIL_ADD=?,MEM_EMAIL=?,MEM_EMAIL_CK=?,MEM_ACCOUNT=?,MEM_PHONE=?,MEM_BIRTH=? where MEM_ID=?";
		getConnect();
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPostNumber());
			pstmt.setString(2, dto.getMemAddress());
			pstmt.setString(3, dto.getDetailAdd());
			pstmt.setString(4, dto.getMemEmail());
			pstmt.setString(5, dto.getMemEmailCk());
			pstmt.setString(6, dto.getMemAccount());
			pstmt.setString(7, dto.getMemPhone());
			long birth = dto.getMemBirth().getTime();
			pstmt.setDate(8, new Date(birth));
			pstmt.setString(9, dto.getMemId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	
	/*sql = "select" + COLUMNS +  "from member where mem_id = mem_id";
	==>
	Statement ~~~~~   ==> 시스템 성능에 안좋아서 요즘 안쓴다
	 ==> 모든프레임워크가 prepareStatement를사용 (?) 를통해서 사용한다 */  
	
	public MemberDTO memDetail(String memId) {
		MemberDTO dto = new MemberDTO();
		sql = "select " + COLUMNS +  " from member where mem_id = ?"; 
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs= pstmt.executeQuery();
			/* System.out.println(rs.getRow()); */
			if(rs.next()) {
				dto.setDetailAdd(rs.getString("DETAIL_ADD"));
				dto.setMemAccount(rs.getString("MEM_ACCOUNT"));
				dto.setMemAddress(rs.getString("MEM_ADDRESS"));
				dto.setMemBirth(rs.getDate("MEM_BIRTH"));
				dto.setMemEmail(rs.getString("MEM_EMAIL"));
				dto.setMemEmailCk(rs.getString("MEM_EMAIL_CK"));
				dto.setMemGender(rs.getString("MEM_GENDER"));
				dto.setMemId(rs.getString("MEM_ID"));
				dto.setMemName(rs.getString("MEM_NAME"));
				dto.setMemPhone(rs.getString("MEM_PHONE"));
				dto.setPostNumber(rs.getString("POST_NUMBER")); // ==> InfoPage 로전달 ==> request에다가 다시저장	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public List<MemberDTO> memList(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		sql = "select " + COLUMNS + " from member";
		getConnect();
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();  //쿼리 결과에대한 셋 ? rs 는 위에 bof가있고 밑에는 eof 가있다  ==> 그 안에있는 데이터를 가져오기 위해서는 next를 해줘야 된다 .
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();//한번 돌때마다 한개씩 만들어야된다 (새로운 값을 저장하려면 새로운 객체를 계속만들어야됨 ==> db에서 한줄 저장하는것은 DTO 한개 ==> 여러개 만들어야지)
				dto.setDetailAdd(rs.getString("DETAIL_ADD"));
				dto.setMemAccount(rs.getString("MEM_ACCOUNT"));
				dto.setMemAddress(rs.getString("MEM_ADDRESS"));
				dto.setMemBirth(rs.getDate("MEM_BIRTH"));
				dto.setMemEmail(rs.getString("MEM_EMAIL"));
				dto.setMemEmailCk(rs.getString("MEM_EMAIL_CK"));
				dto.setMemGender(rs.getString("MEM_GENDER"));
				dto.setMemId(rs.getString("MEM_ID"));
				dto.setMemName(rs.getString("MEM_NAME"));
				dto.setMemPhone(rs.getString("MEM_PHONE"));
				dto.setPostNumber(rs.getString("POST_NUMBER"));
				//pw는 넣지 않는다 
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	
	
	
	
	
	public void memInsert(MemberDTO dto) {
		sql = " insert into member ( " + COLUMNS +" ) "+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPw());
			pstmt.setString(3, dto.getPostNumber());
			pstmt.setString(4, dto.getMemAddress());
			pstmt.setString(5, dto.getDetailAdd());
			pstmt.setString(6, dto.getMemName());
			pstmt.setString(7, dto.getMemPhone());
			
			long birth = dto.getMemBirth().getTime();
			pstmt.setDate(8, new Date(birth));
			pstmt.setString(9, dto.getMemGender());
			pstmt.setString(10, dto.getMemAccount());
			pstmt.setString(11, dto.getMemEmail());
			pstmt.setString(12, dto.getMemEmailCk());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 저장되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	private void close() {
		if(rs != null)	try {rs.close();} 
						catch (SQLException e) {}
		if(pstmt != null)	try {pstmt.close();} 
						catch (SQLException e) {}
		if(conn != null)	try {conn.close();} 
						catch (SQLException e) {}
	}
	
}






