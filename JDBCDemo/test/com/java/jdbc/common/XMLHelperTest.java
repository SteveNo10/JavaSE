package com.java.jdbc.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLHelperTest {

	@Test
	public void test() throws Exception {
		JdbcConnParam jdbcConnParam = XMLHelper.GetConnParam();
		assertEquals(jdbcConnParam.getDbtype(), "mysql");
		assertEquals(jdbcConnParam.getHost(), "172.26.223.44");
		assertEquals(jdbcConnParam.getPort(), "3306");
		assertEquals(jdbcConnParam.getDbname(), "mpv12db");
		assertEquals(jdbcConnParam.getUsername(), "mpv12db");
		assertEquals(jdbcConnParam.getPassword(), "mpv12db");
	}

}
