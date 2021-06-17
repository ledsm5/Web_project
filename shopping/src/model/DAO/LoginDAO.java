package model.DAO;

import java.sql.SQLException;

import model.DTO.AuthInfo;

public class LoginDAO extends DataBaseInfo{
	public AuthInfo login(String userId) {
		AuthInfo authInfo = null;
		sql = "select mem_id as user_id, mem_pw as user_pw , 1 as grade from member where mem_id =? "
				+ "union select EMP_USERID, EMP_PW, EMPLOYEE_ID from employees where EMP_USERID = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				authInfo = new AuthInfo();
				authInfo.setGrade(rs.getString("grade"));
				authInfo.setUserId(rs.getString("user_id"));
				authInfo.setUserPw(rs.getString("user_pw"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return authInfo;
	
	}
	
	
	//=============================위에만큼은 DAO만드는데(DB연동하는데) 필수적으로 필요하다 extends 
	

}
