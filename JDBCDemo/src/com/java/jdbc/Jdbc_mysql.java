package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Jdbc_mysql {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			//No1
			Class.forName("com.mysql.jdbc.Driver");
			
			//No2
			String url = "jdbc:mysql://172.26.223.44:3306/mpv12db";
			String username = "mpv12db";
			String password = "mpv12db";
			
			//No3
			con = DriverManager.getConnection(url, username, password);
			
			//No4
			stmt = con.createStatement();
			
			//PreparedStatement pstmt = con.prepareStatement(sql);
			
			//CallableStatement cstmt = con.prepareCall("{CALL demoSp(? , ?)}");
			
			//No5
			rs = stmt.executeQuery("select count(*) num from t_eap_wf_pending");
			
			//No6
			while(rs.next()) {
				String name = rs.getString("num");
				System.out.println(name);
			}
			
			//No7
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
