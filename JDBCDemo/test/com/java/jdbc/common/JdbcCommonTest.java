package com.java.jdbc.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class JdbcCommonTest {

	@Test
	public void testUpdate() {
		JdbcCommon jdbcCommon = new JdbcCommon();
		assertTrue(jdbcCommon.Conn());
		String insert1 = "insert into Student(id,age,studentname) values(1,23,'John')";
		String insert2 = "insert into Student(id,age,studentname) values(2,25,'Steven')";
		assertTrue(jdbcCommon.Update(insert1));
		assertTrue(jdbcCommon.Update(insert2));
		
		String update1 = "update Student set studentname='Jams' where id=1";
		String update2 = "update Student set age=28 where id=2";
		assertTrue(jdbcCommon.Update(update1));
		assertTrue(jdbcCommon.Update(update2));
		
		String query1 = "select * from Student";
		assertTrue(jdbcCommon.Query(query1));
		
		String del1 = "delete from Student where id=1";
		String del2 = "delete from Student where id=2";
		assertTrue(jdbcCommon.Update(del1));
		assertTrue(jdbcCommon.Update(del2));
		
		String insertParam = "insert into Student(id,age,studentname) values(?,?,?)";
		int[] ids = {1, 2};
		String[] paramInsertNames = {"Name1", "Name2"};
		int[] paramInsertAges = {23, 24};
		assertTrue(jdbcCommon.Batch(insertParam, ids, paramInsertAges, paramInsertNames));
		
		String updateParam = "update Student set studentname=? where id=?";
		String[] paramNames = {"Tom", "Jerry"};
		assertTrue(jdbcCommon.Batch(updateParam, paramNames, ids));
		
		assertTrue(jdbcCommon.Query(query1));
		
		String[] dels = {del1, del2};
		assertTrue(jdbcCommon.Batch(dels));
		
		jdbcCommon.Transaction(insert1, del1);   //Student - student
		jdbcCommon.Query(query1);
		
		jdbcCommon.Transaction(insert1, "delete from student where id=1");   //Student - student
		jdbcCommon.Query(query1);
		
		//存储过程无in参数无out参数无return
		String createProcudeNoInNoOutNoReturn = "Create Procedure AddAgeNoInNoOutNoReturn() begin update Student set age=age+1; end";
		jdbcCommon.Update(createProcudeNoInNoOutNoReturn);
		
		String callProcudeNoInNoOutNoReturn = "{call AddAgeNoInNoOutNoReturn()}";
		jdbcCommon.CallProcedureNoInNoOutNoReturn(callProcudeNoInNoOutNoReturn);
		
		jdbcCommon.Query(query1);
		
		String dropProcudeNoInNoOutNoReturn = "drop procedure if exists AddAgeNoInNoOutNoReturn;";
		jdbcCommon.Update(dropProcudeNoInNoOutNoReturn);
		
		//存储过程有in参数无out参数无return
		String createProcudeNoOutNoReturn = "Create Procedure AddAgeNoOutNoReturn(in newage int) begin update Student set age=newage; end";
		jdbcCommon.Update(createProcudeNoOutNoReturn);
		
		String callProcudeNoOutNoReturn = "{call AddAgeNoOutNoReturn(?)}";
		jdbcCommon.CallProcedureNoOutNoReturn(callProcudeNoOutNoReturn, 15);
		
		jdbcCommon.Query(query1);
		
		String dropProcudeNoOutNoReturn = "drop procedure if exists AddAgeNoOutNoReturn;";
		jdbcCommon.Update(dropProcudeNoOutNoReturn);
		
		//存储过程有in参数有out参数无return
		String createProcudeNoReturn = "Create Procedure AddAgeNoReturn(in newage int, out count int) begin update Student set age=newage; "
				+ "select count(*) into count from Student; end";
		jdbcCommon.Update(createProcudeNoReturn);
		
		String callProcudeNoReturn = "{call AddAgeNoReturn(?,?)}";
		int[] countNoReturn = {0};
		jdbcCommon.CallProcedureNoReturn(callProcudeNoReturn, 10, countNoReturn);
		System.out.println("totalcount=" + countNoReturn[0]);
		
		jdbcCommon.Query(query1);
		
		String dropProcudeNoReturn = "drop procedure if exists AddAgeNoReturn;";
		jdbcCommon.Update(dropProcudeNoReturn);
		
		//存储过程有in参数有out参数有return   mysql存储过程不能有return
//		String createProcude = "Create Procedure AddAge(in newage int, out count int) begin update Student set age=newage; "
//				+ "select count(*) into count from Student; return 0; end";
//		jdbcCommon.Update(createProcude);
//		
//		String callProcude = "{? = call AddAge(?,?)}";
//		int[] count = {0};
//		int[] iReturn = {0};
//		jdbcCommon.CallProcedure(callProcude, 20, count, iReturn);
//		System.out.println("totalcount=" + count[0] + "; return value=" + iReturn[0]);
//		
//		jdbcCommon.Query(query1);
//		
//		String dropProcude = "drop procedure if exists AddAge;";
//		jdbcCommon.Update(dropProcude);
		
		jdbcCommon.Close();
	}

}
