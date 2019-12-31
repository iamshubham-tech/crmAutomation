package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {
	
	public static Properties prop;
	
	public ConfigReader() {
			File src = new File("./Config/Config.properties");
			try {
				FileInputStream file = new FileInputStream(src);
				prop = new Properties();
				prop.load(file);
			} catch (Exception e) {
				System.out.println("Exception is"+e.getMessage());
			}
	}
	public String getAppUrl()
	{
		String appUrl = prop.getProperty("url");
		return appUrl;
	}
	
	public  String getUsername()
	{
		String userName = prop.getProperty("username");
		return userName;
	}
	
	public  String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public  String getChromePath()
	{
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getfirefoxPath()
	{
		String firefoxPath = prop.getProperty("firefoxpath");
		return firefoxPath;
	}
}
