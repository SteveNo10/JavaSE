import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("111", 12);
		int i = (int)map.get("111");
		System.out.println(i);
		
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		if(iterator.hasNext()) {
			System.out.println(((Map.Entry<String, Object>)iterator.next()).getValue());
		}
		
		
		Map<String, String> strMap = new HashMap<String, String>();
		strMap.put("1", "一");
		strMap.put("2", "二");
		strMap.put("3", "三");
		for(Map.Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		for(Map.Entry<String, String> entry : strMap.entrySet()) {
			entry.setValue("十全十美");
		}
		
		for(Map.Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
