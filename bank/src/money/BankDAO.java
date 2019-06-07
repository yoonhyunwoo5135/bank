package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankDAO {
	private String url;
	private String user;
	private String password;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private BankDTO dto;
	
	public BankDTO count() {
		// 1.드라이버 설정
		dto = new BankDTO();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.DB연결
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);

			// 3.SQL문 설정(객체화)
			String sql = "select count(*) from member";
			ps = con.prepareStatement(sql);
			// 4.SQL문 전송
			rs = ps.executeQuery();
			// SQL문의 결과가 있으면, 받아서 처리
			while (rs.next()) {
				int count2 = rs.getInt(1);
				dto.setCount(count2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return dto;
	}

	
	
	public BankDTO insert() {
		dto = new BankDTO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://localhost:3306/bank";
		user = "root";
		password = "1234";
		
		con = DriverManager.getConnection(url, user, password);
		String sql = "insert into member values(?,?,?,?)";
		ps = con.prepareStatement(sql);
		
		ps.setString(1, BankManger.tId.getText());
		ps.setString(2, BankManger.tName.getText());
		ps.setInt(3, Integer.parseInt(BankManger.tAge.getText()));
		ps.setString(4, BankManger.tTel.getText());
		
		ps.executeUpdate();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		finally {
			try {
				if(con != null);
				con.close();
				if(ps != null);
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}	
		return dto;
	}
	
	public BankDTO update() {
		dto = new BankDTO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			
			con = DriverManager.getConnection(url, user, password);
			String sql = "update member set tel = ? where id = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, BankManger.t3.getText());
			ps.setString(2, BankManger.t2.getText());

			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null);
				con.close();
				if(ps != null);
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public BankDTO delete() {
		dto = new BankDTO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from member where id = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, BankManger.t1.getText());
						
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null);
				con.close();
				if(ps != null);
				ps.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public ArrayList select(String id) {
		ArrayList list = new ArrayList();
		dto = new BankDTO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new BankDTO();
				String id1 = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String tel = rs.getString(4);
				
				dto.setId(id1);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				
				list.add(dto);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(con != null);
				con.close();
				if(ps != null);
				ps.close();
				if(rs != null);
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return list;
		}
	}
	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		dto = new BankDTO();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member";
			ps = con.prepareStatement(sql);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new BankDTO();
				String id = rs.getString(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String tel = rs.getString(4);
				
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				
				list.add(dto);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(con != null);
				con.close();
				if(ps != null);
				ps.close();
				if(rs != null);
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return list;
		}
	}
	public BankDTO idcount() {
		dto = new BankDTO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/bank";
			user = "root";
			password = "1234";
			con = DriverManager.getConnection(url, user, password);
			String sql = "select count(*) from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1 , BankManger.id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int count = rs.getInt(1);
				dto.setIdcount(count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return dto;
	}

}
