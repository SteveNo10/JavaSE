package com.java.jdbc;

import java.sql.*;

public class Jdbc_oracle {

	public static void main(String[] args) {
		String strClass = "oracle.jdbc.driver.OracleDriver";
		String strCon = "jdbc:oracle:thin:@172.26.223.129:1521:eap129";
		String username = "mpv12db";
		String password = "mpv12db";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName(strClass);
			
			con = DriverManager.getConnection(strCon, username, password);
			
			PreparedStatement preparedStatement = con.prepareStatement("select * from t_eap_wf_pending");
			rs = preparedStatement.executeQuery();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from t_eap_wf_pending");
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2));
			}
			
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
