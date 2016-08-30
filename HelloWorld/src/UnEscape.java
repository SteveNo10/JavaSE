
public class UnEscape {
	
	private final static byte[] val = { 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x00,
			0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B,
			0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "%7B%22701371ba-04ef-4268-b8d0-c968a868d5e2-11%22%3A%7B%22ObjectType%22%3A%225%22%2C%22ObjectUIType%22%3A%221%22%2C%22ActionType%22%3A%22-1%22%2C%22TriggerRemindType%22%3A%221%22%2C%22AllowMsgNotify%22%3A%220%22%2C%22MsgRemindTimes%22%3A%221%22%2C%22MsgRemindInterval%22%3A%2230%22%2C%22MsgRemindIntervalUnit%22%3A%22M%22%2C%22MsgRemindDelay%22%3A%220%22%2C%22MsgRemindDelayUnit%22%3A%22M%22%2C%22MsgRemindContent%22%3A%22%22%2C%22AllowMailNotify%22%3A%221%22%2C%22MailRemindTimes%22%3A%221%22%2C%22MailRemindInterval%22%3A%2230%22%2C%22MailRemindIntervalUnit%22%3A%22M%22%2C%22MailRemindDelay%22%3A%220%22%2C%22MailRemindDelayUnit%22%3A%22M%22%2C%22MailRemindContent%22%3A%22%25u90AE%25u4EF6%25u5185%25u5BB9%257Bwf%253Ainitiator_datetime1%257D123%250A123456789.@@@+++2.%22%2C%22IsAllAction%22%3A%22false%22%2C%22MailTitle%22%3A%22%25u90AE%25u4EF6%25u6807%25u9898%257Bwf%253Adatetime1%257D%22%2C%22IsEmailAudit%22%3A%220%22%2C%22RemindUserID%22%3A%22701371ba-04ef-4268-b8d0-c968a868d5e2%22%2C%22RemindUserName%22%3A%22%5B%u6D2A%u5251%u5CF0%5Dhongjf%22%2C%22ActionName%22%3A%22%20%u6240%u6709%u52A8%u4F5C%22%2C%22RemindUrgeObject%22%3A%22%22%2C%22RemindUrgeObjectName%22%3A%22%22%2C%22RemindUrgeObjectType%22%3A%220%22%2C%22RemindUrgeObjectUIType%22%3A%221%22%2C%22extend_property%22%3A%22%22%7D%7D";
		String str1 = unescape(str);
		System.out.println(str1);
		

	}
	
	public static String unescape1(String s) {
		StringBuffer sbuf = new StringBuffer();
		int i = 0;
		int len = s.length();
		while (i < len) {
			int ch = s.charAt(i);
			if (ch == '+') { // + : map to ' '
				sbuf.append(' ');
			} else if (('A' <= ch) && (ch <= 'Z')) { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if (('a' <= ch) && (ch <= 'z')) { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if (('0' <= ch) && (ch <= '9')) { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if ((ch == '-')
					|| (ch == '_' // unreserved : as it was
					) || (ch == '.') || (ch == '!') || (ch == '~') || (ch == '*') || (ch == '\'') || (ch == '(')
					|| (ch == ')')) {
				sbuf.append((char) ch);
			} else if (ch == '%') {
				int cint = 0;
				if ('u' != s.charAt(i + 1)) { // %XX : map to ascii(XX)
					cint = (cint << 4) | val[s.charAt(i + 1)];
					cint = (cint << 4) | val[s.charAt(i + 2)];
					i += 2;
				} else { // %uXXXX : map to unicode(XXXX)
					cint = (cint << 4) | val[s.charAt(i + 2)];
					cint = (cint << 4) | val[s.charAt(i + 3)];
					cint = (cint << 4) | val[s.charAt(i + 4)];
					cint = (cint << 4) | val[s.charAt(i + 5)];
					i += 5;
				}
				sbuf.append((char) cint);
			}
			i++;
		}
		return sbuf.toString();
	}
	
	public static String unescape(String src) {  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length());  
        int lastPos = 0, pos = 0;  
        char ch;  
        while (lastPos < src.length()) {  
            pos = src.indexOf("%", lastPos);  
            if (pos == lastPos) {  
                if (src.charAt(pos + 1) == 'u') {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 2, pos + 6), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 6;  
                } else {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 1, pos + 3), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 3;  
                }  
            } else {  
                if (pos == -1) {  
                    tmp.append(src.substring(lastPos));  
                    lastPos = src.length();  
                } else {  
                    tmp.append(src.substring(lastPos, pos));  
                    lastPos = pos;  
                }  
            }  
        }  
        return tmp.toString();  
    }  
}
