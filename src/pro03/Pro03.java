package pro03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pro03 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			 
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = " select e.employee_id, " + 
		    		"       e.first_name||' '||e.last_name as full_name, " + 
		    		"       e.email, " + 
		    		"       j.job_title, " + 
		    		"       d.department_name, " + 
		    		"       l.city " + 
		    		" from employees e, " + 
		    		"     departments d, " + 
		    		"     locations l, " + 
		    		"     jobs j " + 
		    		" where e.department_id = d.department_id " + 
		    		"  and d.location_id = l.location_id " + 
		    		"  and e.job_id = j.job_id " + 
		    		"  and j.job_id = 'PU_CLERK' " + 
		    		"  and city = 'Seattle' " + 
		    		" order by employee_id desc " ;
		    
		    pstmt = conn.prepareStatement(query);
		    
		    rs = pstmt.executeQuery();
			
		  System.out.println("employeeId   Full_Name      Email       jobTitle           dept.Name          City");
		    // 4.결과처리
		   
		    while(rs.next()) {
		    	
		    	int employeeId = rs.getInt("employee_id");
		    	String name = rs.getString("full_name");
		    	String email = rs.getString("email");
		    	String jobTitle = rs.getString("job_title");
		    	String departName = rs.getString("department_name");
		    	String city = rs.getString("city");
		    	
		    	System.out.println(employeeId + "  " + name + "     " + email + "     " + jobTitle + "     " + departName + "     " + city);
		    }
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}


    }


}
