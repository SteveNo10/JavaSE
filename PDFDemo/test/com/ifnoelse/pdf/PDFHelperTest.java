package com.ifnoelse.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PDFHelperTest {

	@Test
	public void test() throws Exception {
		//PDFHelper.GenerateFile("http://localhost:8080/MyServlet/ThreeParams/ThreeParams.htm");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i=0; i<10; ++i) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("key1", "value1");
			row.put("key2", "value2");
			row.put("key3", "value3");
			list.add(row);
		}
		
		PDFHelper.GenerateFile(list);
	}

}
