package com.java.regex;

import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String strOri = "[{\"key\":\"LYButton1\",\"value\":\"\"},{\"key\":\"LYButton2\",\"value\":\"\"},{\"key\":\"LYLabel1\",\"value\":\"\"},{\"key\":\"LYTextBox5\",\"value\":\"\"},{\"key\":\"LYButton3\",\"value\":\"\"},{\"key\":\"LYTextBox2\",\"value\":\"01906\"},{\"key\":\"LYIntegerBox1\",\"value\":\"\"},{\"key\":\"LYButton4\",\"value\":\"\"},{\"key\":\"LYTextBox1\",\"value\":\"\"},{\"key\":\"LYComboBox1\",\"value\":\"\"},{\"key\":\"LYComboBox2\",\"value\":\"\"},{\"key\":\"LYTextBox3\",\"value\":\"\"},{\"key\":\"LYTextBox4\",\"value\":\"\"},{\"key\":\"LYDateBox1\",\"value\":\"\"},{\"key\":\"LYBaseData1\",\"value\":\"\"},{\"key\":\"LYPrimaryKey1\",\"value\":\"12892307-2e73-4a39-9a00-11cfb21ff147\"}]";
		String strOriSim = "abcdefg";
		String strPattern = "[a-d[m-z]]";
		Pattern pattern = Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE);
		String[] splits = pattern.split(strOriSim);
		for(String s : splits) {
			System.out.println(s);
		}
	}

}
