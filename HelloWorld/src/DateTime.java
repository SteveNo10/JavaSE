import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	public static void main(String[] args) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
//		Date date = new Date(calendar.getTimeInMillis());
//		System.out.println(date);
//		
//		Calendar calendar1 = Calendar.getInstance();
//		Date date1 = new Date(calendar1.getTimeInMillis());
//		System.out.println(date1);
		
		
		
		Calendar temp = Calendar.getInstance();
        temp.set(Calendar.YEAR, 2016);
        temp.set(Calendar.MONTH, 1);
        int maxDayOfMonth = temp.getActualMaximum(Calendar.DATE);
        System.out.println(maxDayOfMonth);
        
        
        Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(temp.get(Calendar.YEAR));
		System.out.println(temp.get(Calendar.MONTH));
		System.out.println(temp.get(Calendar.DAY_OF_MONTH));
		System.out.println(temp.get(Calendar.WEEK_OF_MONTH));
		System.out.println(temp.get(Calendar.DAY_OF_WEEK));
		
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DATE, 30);
		cale.add(Calendar.DATE, 1);
		System.out.println(cale.getTime());
		
		Calendar calendarDayOfWeek = Calendar.getInstance();
		calendarDayOfWeek.add(Calendar.DATE, 5);
		System.out.println(calendarDayOfWeek.get(Calendar.DAY_OF_WEEK));
		
		SimpleDateFormat simpleHM = new SimpleDateFormat("hh:mm");
		SimpleDateFormat simpleYMDHM = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String strHM = "08:40";
		Calendar calendarHourMinu = Calendar.getInstance();
		try {
			calendarHourMinu.setTime(simpleHM.parse(strHM));
			System.out.println(calendarHourMinu);
			
			Calendar now = Calendar.getInstance();
            now.setTime(simpleYMDHM.parse(simpleYMDHM.format(now.getTime())));
            System.out.println(now.getTime());
		}
		catch (Exception ex) {
			System.out.println("parse error");
		}
		
		
	}
}
