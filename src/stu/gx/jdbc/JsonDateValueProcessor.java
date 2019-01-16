package stu.gx.jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor 
{ 
	private String format = "yyyy-MM-dd HH:mm:ss"; 
	public JsonDateValueProcessor() { super(); } 
	public JsonDateValueProcessor(String format) 
	{ // �Լ���Ҫ�ĸ�ʽ super(); 
		this.format = format; 
	} 
	
	public Object processArrayValue(Object value, JsonConfig paramJsonConfig) 
	{ return process(value); } 
	
	public Object processObjectValue(String key, Object value, JsonConfig paramJsonConfig) 
	{ return process(value); } 
	
	private Object process(Object value) { 
		if (value instanceof Date) 
		{ 
			SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA); 
			return sdf.format(value); 
		} 
		return value == null ? "" : value.toString(); 
	} 
}
		
	

