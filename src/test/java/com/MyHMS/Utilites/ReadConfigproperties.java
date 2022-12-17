package com.MyHMS.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigproperties {
	Properties properties;
	String path="D:\\my pen drive\\Myhms\\Configuration\\config.properties";
	
	public ReadConfigproperties(){
		properties=new Properties();
		try {
			FileInputStream fi=new FileInputStream(path);
			try {
				properties.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public String getUrl() {
		String baseUrl=properties.getProperty("baseUrl");
		if(baseUrl!=null) 
			return baseUrl;
			else
				throw new RuntimeException("baseUrl is not specified");
		
	}
	
	public String getbrowser1() {
		String browser1=properties.getProperty("browser1");
		if(browser1!=null) 
			return browser1;
			else
				throw new RuntimeException("browser1 is not specified");
		
	}
	
	public String getbrowser2() {
		String browser2=properties.getProperty("browser2");
		if(browser2!=null) 
			return browser2;
			else
				throw new RuntimeException("browser2 is not specified");
		
	}
	
	public String getbrowser3() {
		String browser3=properties.getProperty("browser3");
		if(browser3!=null) 
			return browser3;
			else
				throw new RuntimeException("browser3 is not specified");
		
	}
}
