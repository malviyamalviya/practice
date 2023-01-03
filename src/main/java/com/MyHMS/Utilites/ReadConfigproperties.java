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
		String browser=properties.getProperty("browser");
		if(browser!=null) 
			return browser;
			else
				throw new RuntimeException("browser1 is not specified");
		
	}
	
	
	}

