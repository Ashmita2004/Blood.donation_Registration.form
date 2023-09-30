package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Donor {
	
	private String contact;
	private String name, email, blood_group, address, gender;
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static Connection connect() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		String url = "jdbc:mysql://localhost:3306/my_firstdb";
		String user = "root";
		String password = "";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		return conn;
	}
		
		public int addDonor() throws SQLException {
			
			Connection conn = connect();
			
			String sql = "insert into blood_donation values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, contact);
			ps.setString(4, blood_group);
			ps.setString(5, address);
			ps.setString(6, gender);
			
			int response = ps.executeUpdate();
			

			conn.close();
			return response;
		}
		
	}

