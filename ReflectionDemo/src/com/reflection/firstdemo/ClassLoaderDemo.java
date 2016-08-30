package com.reflection.firstdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassLoaderDemo {
	public static void main(String args[]) throws Exception {
		System.out.println("classLoader...................................................");
		Class<?> myclass = Class.forName("com.reflection.firstdemo.Person");
		System.out.println(myclass.getClassLoader().getClass().getName());
		System.out.println(myclass.getClassLoader().getParent().getClass().getName());
		
		Object obj1 = myclass.newInstance();
		
		System.out.println("Field............................................................");
		Field[] fields = myclass.getFields();
		for(Field field : fields) {
			System.out.println(field.getName() + "   field.type:" + field.getType() + "   field.modifier:" + field.getModifiers());
		}
		
		System.out.println("getField...........................................................");
		Field getfield = myclass.getField("tag");
		Object getfieldObject = getfield.get(obj1);
		System.out.println(getfieldObject.getClass().getName() + ":" + getfieldObject);
		getfield.set(obj1, "LALALALA");
		Object aftergetfieldObject = getfield.get(obj1);   //必须重新获取，否则还是之前的值
		System.out.println(aftergetfieldObject.getClass().getName() + ":" + aftergetfieldObject);
		
		System.out.println("DeclaredField.....................................................");
		Field[] declearedFields = myclass.getDeclaredFields();
		for(Field field : declearedFields) {
			System.out.println(field.getName() + "   field.type:" + field.getType() + "   field.modifier:" + field.getModifiers());
		}
		
		System.out.println("getDeclaredField...........................................................");
		Field getdeclaredfield = myclass.getDeclaredField("age");
		getdeclaredfield.setAccessible(true);   //非public成员变量必须先设置，才能访问
		Object getdeclaredfieldObject = getdeclaredfield.get(obj1);
		System.out.println(getdeclaredfieldObject.getClass().getName() + ":" + getdeclaredfieldObject);
		getdeclaredfield.set(obj1, 20);
		Object aftergetdeclaredfieldobject = getdeclaredfield.get(obj1);   //必须重新获取，否则还是之前的值
		System.out.println(aftergetdeclaredfieldobject.getClass().getName() + ":" + aftergetdeclaredfieldobject);
		
		System.out.println("Constructor.....................................................................");
		Constructor<?>[] constructors = myclass.getConstructors();
		for(Constructor<?> constructor : constructors) {
			System.out.println("constructor name : " + constructor.getName());
			Parameter[] parameters = constructor.getParameters();
			for(Parameter parameter : parameters) {
				System.out.println("   parameter : " + parameter.getName() + "   parameter.getType : " + parameter.getType());
			}
		}
		
		System.out.println("getConstructor.......................................................................");
		Constructor<?> getconstructor = myclass.getConstructor();
		Object obj2 = getconstructor.newInstance();
		System.out.println("obj2 : " + ((Person)obj2));
		
		Constructor<?> getconstructor3 = myclass.getConstructor(int.class, String.class, String.class);
		Object obj3 = getconstructor3.newInstance(30, "Jay", "Singer");
		System.out.println("obj3 : " + ((Person)obj3));
		
		System.out.println("declaredConstructor.....................................................................");
		Constructor<?>[] declaredconstructors = myclass.getConstructors();
		for(Constructor<?> constructor : declaredconstructors) {
			System.out.println("constructor name : " + constructor.getName());
			Parameter[] parameters = constructor.getParameters();
			for(Parameter parameter : parameters) {
				System.out.println("   parameter : " + parameter.getName() + "   parameter.getType : " + parameter.getType());
			}
		}
		
		System.out.println("Method......................................................................");
		Method[] methods = myclass.getMethods();
		for(Method method : methods) {
			System.out.println(method.getName() + "    returntype : " + method.getReturnType());
			Parameter[] parameters = method.getParameters();
			for(Parameter parameter : parameters) {
				System.out.println("   parameter: " + parameter.getName() + "   parameter.getType : " + parameter.getType());
			}
		}
		
		System.out.println("getMethod.......................................................................");
		Method getmethod = myclass.getMethod("setName", String.class);
		getmethod.invoke(obj1, "JJ");
		Method getmethod2 = myclass.getMethod("Print");
		getmethod2.invoke(obj1);
		
		System.out.println("DeclaredMethod..............................................................");
		Method[] declaredmethods = myclass.getDeclaredMethods();
		for(Method method : declaredmethods) {
			System.out.println(method.getName() + "   returntype : " + method.getReturnType());
			Parameter[] parameters = method.getParameters();
			for(Parameter parameter : parameters) {
				System.out.println("   parameter: " + parameter.getName() + "   parameter.getType : " + parameter.getType());
			}
		}
		
		System.out.println("getDeclaredMethod.......................................................................");
		Method getdeclaredmethod = myclass.getDeclaredMethod("Eat", String.class);
		getdeclaredmethod.invoke(obj1, "apple");
	}
}

class Person {
	private int age = 18;
	protected String name = "empty";
	public String tag = "empty";
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Person() {
		
	}
	
	public Person(int age, String name, String tag) {
		this.age = age;
		this.name = name;
		this.tag = tag;
	}
	
	private void AddAge() {
		this.setAge(this.getAge() + 1);
		System.out.println("after add age : " + this.getAge());
	}
	
	protected void Eat(String food) {
		System.out.println("Eat food:" + food + " then age will add");
		AddAge();
	}
	
	public void Print() {
		System.out.println("name is " + this.getName() + "; and age is " + this.getAge());
	}
	
	@Override
	public String toString() {
		return this.getName() + " is a " + this.getAge() + " person, the tag is " + this.getTag();
	}
}

