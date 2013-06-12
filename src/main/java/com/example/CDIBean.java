package com.example;

import javax.enterprise.inject.Alternative;

/**
 * This bean will be injected to trigger the bug
 * 
 */
@Alternative
public class CDIBean {
	
	private String data;

	
	public String getData() {
		return data;
	}

	
	public void setData(String data) {
		this.data = data;
	}
	
	

}
