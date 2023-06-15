package com.vt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.vt.constants.Constants;
import com.vt.enums.ConfigProperties;

public class ConfigPropertyUtils {
	
	private ConfigPropertyUtils() {
	}
	
	private static Properties property = new Properties();
	private static final Map<String, String> ConfigMap = new HashMap<>();
	
	
	 /**
     * Instead of doing the FileInputStream operation each time the fetch value is called
     * Property is stored by default in HashTable which is thread safe but also comparatively slow.
     * So instead we are storing it in HashMap which is relatively faster
     *
     * Static block is ideal solution for this scenario
     */
	static {
		try {
			FileInputStream file = new FileInputStream(Constants.CONFIGFILEPATH);			
			property.load(file);
			property.entrySet().forEach(entry -> ConfigMap.put(String.valueOf(entry.getKey()),  String.valueOf(entry.getValue())));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getValue(ConfigProperties key) throws Exception {
		
		if (Objects.isNull(ConfigMap.get(key.name().toLowerCase()))) {
			throw new Exception("Property name "+key.toString()+" is not found. Please check config properties file");		
		}
		return property.getProperty(key.name().toLowerCase());
	}

}
