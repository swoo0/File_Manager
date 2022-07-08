package kr.co.file.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kr.co.file.controller.FileController;

public class AnnotationHandler {
	
	public void action(String url) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		FileController con = new FileController();
		
		Class<?> c = con.getClass();
		
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			Annotation annotation = method.getAnnotation(RequestMapping.class);
			if (annotation instanceof RequestMapping) {
				RequestMapping requestMapping = (RequestMapping) annotation;
				if (url.equals(requestMapping.url())) {
					method.invoke(c.newInstance());
				}
			}
		}
		
		
	}
	
	
}
