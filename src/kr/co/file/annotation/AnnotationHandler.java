package kr.co.file.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kr.co.file.controller.FileController;

public class AnnotationHandler {
	
	public void action(String url) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		FileController con = new FileController();
		
		Class<?> c = con.getClass();
		
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(RequestMapping.class)) {
				RequestMapping anno = method.getAnnotation(RequestMapping.class);
				if (anno.value().equals(url)) {
					method.invoke(c.newInstance());
				}
			}
		}
		
	}
	
}