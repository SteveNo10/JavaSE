import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CalendarTest {

	public static void main(String[] args) throws ParseException {
		Set<Integer> weeks = new HashSet<Integer>();
		weeks.add(1);
		weeks.add(2);
		weeks.add(3);
		weeks.add(4);
		
		System.out.println(weeks.contains(5));
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		cal.setTime(sdf.parse("2016/7/4 9:50"));
		System.out.println(cal.getTime());
		//cal.add(Calendar.DAY_OF_WEEK, 3);
		//System.out.println("week: " + cal.get(Calendar.DAY_OF_WEEK));
		//ÈÕ£º1
		//Ò»£º2
		//¶þ£º3
		//
		//
		//
		//Áù£º7
		
		String str = "aaa;bbb;ccc;";
		String[] strs = str.split(";");
		int i=0;
		System.out.println(strs[i++]);
		System.out.println(strs[i++]);
		System.out.println(strs[i++]);
		System.out.println(strs[i++]);
	}

}
