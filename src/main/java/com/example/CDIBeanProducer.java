package com.example;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * 
 * This producer will produce CDIBean
 *
 */
public class CDIBeanProducer {
	
	private Logger logger = Logger.getLogger(CDIBeanProducer.class.getCanonicalName());
	
	@Produces
	public CDIBean produce(InjectionPoint ip){
		
		String logText = ip==null ? "InjectionPoint is NULL when producing CDIBean"
				: "InjectionPoint exists when producing CDIBean";
		logger.info(logText);
		
		return new CDIBean();
		
	}

}
