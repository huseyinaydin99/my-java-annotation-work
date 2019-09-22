package com.huseyinaydin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
	String os() default "symbian";
	double version() default 1.0;
}

@SmartPhone(os = "android",version = 4.2)
class NokiaASeries {
	private String model;
	private int size;
	public NokiaASeries(String model, int size) {
		super();
		this.model = model;
		this.size = size;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

public class Main {

	public static void main(String[] args) {
		NokiaASeries nokiaASeries = new NokiaASeries("Fire", 5);
		System.out.println(nokiaASeries.getModel());
		Class class1 = nokiaASeries.getClass();
		Annotation annotation = class1.getAnnotation(SmartPhone.class);
		SmartPhone smartPhone = (SmartPhone)annotation;
		System.out.println(smartPhone.os());
	}

}
