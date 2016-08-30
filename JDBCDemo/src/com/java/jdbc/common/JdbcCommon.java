package com.java.jdbc.common;

import java.sql.*;

public class JdbcCommon {
	private JdbcConnParam jdbcConnParam;
	private Connection conn;
	
	public JdbcCommon() {
		
	}
	
	public boolean Conn() {
		try {
			jdbcConnParam = XMLHelper.GetConnParam();
			String strDriver = null;
			String strConn = null;
			if(jdbcConnParam.getDbtype().equals("oracle")) {
				strDriver = "oracle.jdbc.driver.OracleDriver";
				strConn = "jdbc:oracle:thin:@" + jdbcConnParam.getHost() + ":" + jdbcConnParam.getPort() + ":" + jdbcConnParam.getDbname();
			}
			else if(jdbcConnParam.getDbtype().equals("mysql")) {
				strDriver = "com.mysql.jdbc.Driver";
				strConn = "jdbc:mysql://" + jdbcConnParam.getHost() + ":" + jdbcConnParam.getPort() + "/" + jdbcConnParam.getDbname();
			}
			Class.forName(strDriver);
			
			conn = DriverManager.getConnection(strConn, jdbcConnParam.getUsername(), jdbcConnParam.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("connection failed!");
			return false;
		}
		return true;
	}
	
	public void Close() {
		try {
			if(conn != null) {
				conn.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("close conn error");
		}
	}
	
	public boolean Update(String sql) {
		boolean result = true;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}
		catch (Exception e) {
			result = false;
			System.out.println("update failed! : " + e.getMessage());
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				}
				catch (Exception e) {
					System.out.println("update close error! : " + e.getMessage());
				}
			}
		}
		
		return result;
	}
	
	public boolean Batch(String[] sqls) {
		boolean result = true;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("");
			for(String sql : sqls) {
				ps.addBatch(sql);
			}
			
			ps.executeBatch();
		}
		catch (Exception e) {
			result = false;
			System.out.println("batch failed! : " + e.getMessage());
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				}
				catch (Exception e) {
					System.out.println("batch close error! : " + e.getMessage());
				}
			}
		}
		
		return result;
	}
	
	public boolean Batch(String sql, String[] paramName, int[] id) {
		boolean result = true;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			int count = paramName.length;
			for(int i=0; i<count; ++i) {
				ps.setString(1, paramName[i]);
				ps.setInt(2, id[i]);
				ps.addBatch();
			}
			
			ps.executeBatch();
		}
		catch (Exception e) {
			result = false;
			e.printStackTrace();
			System.out.println("batch failed!");
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("batch close error!");
				}
			}
		}
		
		return result;
	}
	
	public boolean Batch(String sql, int[] ids, int[] ages, String[] paramNames) {
		boolean result = true;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			int count = ids.length;
			for(int i=0; i<count; ++i) {
				ps.setInt(1, ids[i]);
				ps.setInt(2, ages[i]);
				ps.setString(3, paramNames[i]);
				ps.addBatch();
			}
			
			ps.executeBatch();
		}
		catch (Exception e) {
			result = false;
			e.printStackTrace();
			System.out.println("batch failed!");
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("batch close error!");
				}
			}
		}
		
		return result;
	}
	
	public boolean Transaction(String sqlInsert, String sqlDel) {
		boolean result = true;
		PreparedStatement psInsert = null;
		PreparedStatement psDel = null;
		try {
			conn.setAutoCommit(false);
			psInsert = conn.prepareStatement(sqlInsert);
			psInsert.executeUpdate();
			psDel = conn.prepareStatement(sqlDel);
			psDel.executeUpdate();
			conn.commit();
		}
		catch (Exception e) {
			result = false;
			System.out.println("transaction failed : " + e.getMessage());
			try {
				conn.rollback();
			}
			catch(Exception eRollBack) {
				System.out.println("transaction rollback failed! : " + eRollBack.getMessage());
			}
		}
		finally {
			try {
				if(psInsert != null) {
					psInsert.close();
				}
				if(psDel != null) {
					psDel.close();
				}
			}
			catch (Exception e) {
				System.out.println("transaction close error! : " + e.getMessage());
			}
		}
		
		return result;
	}
	
	public boolean CallProcedure(String sql, int param, int[] count, int[] iReturn) {
		boolean result = true;
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, param);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			count[0] = cs.getInt(3);
			iReturn[0] = cs.getInt(1);
		}
		catch (Exception e) {
			result = false;
			System.out.println("CallProcedureNoReturn failed! : " + e.getMessage());
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
				}
			}
			catch (Exception e) {
				System.out.println("CallProcedureNoReturn close error! : " + e.getMessage());
			}
		}
		return result;
	}
	
	public boolean CallProcedureNoReturn(String sql, int param, int[] count) {
		boolean result = true;
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, param);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			count[0] = cs.getInt(2);
		}
		catch (Exception e) {
			result = false;
			System.out.println("CallProcedureNoReturn failed! : " + e.getMessage());
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
				}
			}
			catch (Exception e) {
				System.out.println("CallProcedureNoReturn close error! : " + e.getMessage());
			}
		}
		return result;
	}
	
	public boolean CallProcedureNoOutNoReturn(String sql, int param) {
		boolean result = true;
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(sql);
			cs.setInt(1, param);
			cs.execute();
		}
		catch (Exception e) {
			result = false;
			System.out.println("CallProcedureNoOutNoReturn failed! : " + e.getMessage());
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
				}
			}
			catch (Exception e) {
				System.out.println("CallProcedureNoOutNoReturn close error! : " + e.getMessage());
			}
		}
		return result;
	}
	
	public boolean CallProcedureNoInNoOutNoReturn(String sql) {
		boolean result = true;
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(sql);
			cs.execute();
		}
		catch (Exception e) {
			result = false;
			System.out.println("CallProcedureNoInNoOutNoReturn failed! : " + e.getMessage());
		}
		finally {
			try {
				if(cs != null) {
					cs.close();
				}
			}
			catch (Exception e) {
				System.out.println("CallProcedureNoInNoOutNoReturn close error! : " + e.getMessage());
			}
		}
		return result;
	}
	
	public boolean Query(String sql) {
		boolean result = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colNum = rsmd.getColumnCount();
			for(int i=1; i<=colNum; ++i) {
				System.out.print(rsmd.getColumnName(i) + "    ");
			}
			System.out.println("");
			while(rs.next()) {
				for(int j=1; j<=colNum; ++j) {
					System.out.print(rs.getObject(j) + "    ");
				}
				System.out.println("");
			}
		}
		catch (Exception e) {
			result = false;
			System.out.println("query failed! : " + e.getMessage());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
			}
			catch (Exception e) {
				System.out.println("query close error! : " + e.getMessage());
			}
		}
		
		return result;
	}
}
