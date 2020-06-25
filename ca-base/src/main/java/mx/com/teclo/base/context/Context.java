package mx.com.teclo.base.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mx.com.teclo.base.configuration.BeanConfiguration;

public final class Context {
	
	private static ApplicationContext applicationContext;
	
	private Context () {}
	
	public static ApplicationContext getApplicationContext(){
		if (applicationContext == null){
//			applicationContext = new ClassPathXmlApplicationContext("core-spring-context.xml");
			applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		}
		return applicationContext;
	}
	
}