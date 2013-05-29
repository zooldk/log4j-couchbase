package dk.braintrust.os.logger;

import java.util.HashMap;

/**
 * @author Steffen Larsen (slarsen@braintrust.dk)
 *
 */
public class JsonLogObj {
	private String message;
	private String source_host;
	
	private String clazz;
	private String loggerName;
	private String level;		
	private String thread;
	private Long timestamp;
	
	
    private HashMap<String, Object> fieldData;
    private HashMap<String, Object> exceptionInformation;
	
	public String getHostname() {
		return source_host;
	}
	public void setHostname(String hostname) {
		this.source_host = hostname;
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
		return message;
	}
	public void setMsg(String msg) {
		this.message = msg;
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
