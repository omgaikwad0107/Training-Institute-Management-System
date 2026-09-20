package org.techhub.Config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context1=new AnnotationConfigWebApplicationContext();
		context1.register(DBConfig.class);
		servletContext.addListener(new ContextLoaderListener(context1));
		
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(WebMvcConfig.class);
		
		DispatcherServlet ds=new DispatcherServlet(context); 
		
		ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher", ds);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
