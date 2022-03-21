package com.lwl.cj.day22;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocType{
	String title() default "Sample Title";
	int version() default 0;
	String[] authors() default {};
}


@DocType(title="Learn Java",version = 1,authors = {"Krish","Manoj"})
public class AnnotationExample {

	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
	}
		public static void main(String[] args) {
			
				Annotation[] annArr = AnnotationExample.class.getAnnotations();
				for(Annotation ele:annArr) {
					if(ele instanceof DocType) {
						DocType obj = (DocType) ele;
						System.out.println(obj.title());
						System.out.println(obj.version());
						System.out.println(Arrays.toString(obj.authors()));
					}
				}
		}
}
