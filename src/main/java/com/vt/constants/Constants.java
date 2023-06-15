package com.vt.constants;

public final class Constants {
	
	private Constants() {}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	public static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final int EXPLICITWAIT = 10;
	
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	

}
