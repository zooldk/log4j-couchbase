package dk.braintrust.os.logger;

import java.util.HashMap;

public class JsonLogObj {
	private String clazz;
	private String loggerName;
	private String level;	
	private String msg;
	private String hostname;
	private String thread;
	private Long timestamp;
	
	
    private HashMap<String, Object> fieldData;
    private HashMap<String, Object> exceptionInformation;
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	public HashMap<String, Object> getExceptionInformation() {
		return exceptionInformation;
	}
	public void setExceptionInformation(HashMap<String, Object> exceptionInformation) {
		this.exceptionInformation = exceptionInformation;
	}
	public HashMap<String, Object> getFieldData() {
		return fieldData;
	}
	public void setFieldData(HashMap<String, Object> fieldData) {
		this.fieldData = fieldData;
	}
	
	
}
