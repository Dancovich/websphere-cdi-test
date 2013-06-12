package com.example;

import java.io.IOException;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private BeanManager manager;
	
	@Inject
	private Instance<AnotherBean> anotherBeanInstance;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//There should be an injection point when using this instance.
		AnotherBean anotherBean = this.anotherBeanInstance.get();
		anotherBean.setData("Test");

		//Here we instantiate the bean without an InjectionPoint, so the producer shouldn't receive one
		CDIBean beanManagerInstance;
		Set<Bean<?>> beanList = manager.getBeans(CDIBean.class);
		if (beanList!=null && !beanList.isEmpty()){
			Bean<?> bean = beanList.iterator().next();
			CreationalContext<?> context = manager.createCreationalContext(bean);
			beanManagerInstance = (CDIBean) manager.getReference(bean, CDIBean.class, context);
			
			beanManagerInstance.setData("Test");
		}

		super.doPost(req, resp);
	}
	
	

}
