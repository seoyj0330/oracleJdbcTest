package pro05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro04.MemberVo;

public class BookShopDao {

	public void insert(BookVo vo) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "insert into bookshop values(seq_author_id.nextval, ? , null , null , ? , '1' )";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getTitle()); 
			pstmt.setString(2, vo.getAuthorName());
			
			int count = pstmt.executeUpdate();			
			
			// 4.결과처리
			System.out.println(count + "건 저장완료");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("error: 드라이버 로딩 실패 - " + e);
	
		} catch (SQLException e) {
		
			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리
			try {
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
	
	public void rent(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = " update bookshop set state_code = '0' " + 
							" where id = ? " ;
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, num);

			pstmt.executeUpdate();			
			
			// 4.결과처리
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("error: 드라이버 로딩 실패 - " + e);
	
		} catch (SQLException e) {
		
			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리
			try {
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
	
	public List<BookVo> getListAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BookVo> bookList = new ArrayList<BookVo>();

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = " select id "+
					    	      " ,title "+
					    	      " ,pubs "+
					    	      " ,pub_date "+
					    	      " ,author_name "+
					    	      " ,state_code "+
					    	" from bookshop ";
		    
		    pstmt = conn.prepareStatement(query);
		    rs = pstmt.executeQuery();
		   
		    // 4.결과처리
		    while(rs.next()) {
		    	
		    	BookVo vo = new BookVo();
		    	
		    	int id = rs.getInt("id");
		    	String title = rs.getString("title");
			    String pubs = rs.getString("pubs");
			    String pub_date = rs.getString("pub_date");
			    String author_name = rs.getString("author_name");
			    String state_code = rs.getString("state_code");
			    
			    vo.setId(id);
			    vo.setTitle(title);
			    vo.setPubs(pubs);
			    vo.setPub_date(pub_date);
			    vo.setAuthorName(author_name);
			    vo.setState_code(state_code);
			   
			    bookList.add(vo);
			    
				    
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
		 return bookList;
	}
	
}
	

