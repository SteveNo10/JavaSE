import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void GetFruitInfo(Class<?> clazz) {
		String strFruitName = " ˮ������:";
		String strFruitColor = " ˮ����ɫ:";
		String strFruitProvider = " ˮ����Ӧ��:";
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(FruitName.class)) {
				FruitName name = (FruitName)field.getAnnotation(FruitName.class);
				strFruitName += name;
				System.out.println(strFruitName);
			}
			else if(field.isAnnotationPresent(FruitColor.class)) {
				FruitColor color = (FruitColor)field.getAnnotation(FruitColor.class);
				strFruitColor += color;
				System.out.println(strFruitColor);
			}
			else if(field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider provider = (FruitProvider)field.getAnnotation(FruitProvider.class);
				strFruitProvider += provider;
				System.out.println(strFruitProvider);
			}
		}
	}
}
