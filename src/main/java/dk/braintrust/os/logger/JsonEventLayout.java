package dk.braintrust.os.logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

import com.google.gson.Gson;

/**
 * This layout is based on https://github.com/lusis/log4j-jsonevent-layout/blob/master/src/main/java/net/logstash/log4j/JSONEventLayout.java#L10
 * @author Steffen Larsen (slarsen@braintrust.dk)
 *
 */
public class JsonEventLayout extends Layout {
    private static Gson gson = new Gson();
    private String ndc;
    private Map mdc;
    private LocationInfo info;
    private HashMap<String, Object> fieldData;
    private HashMap<String, Object> exceptionInformation;

    
	public void activateOptions() {
		
	}

	@Override
	public String format(LoggingEvent event) {
		info = event.getLocationInformation();
        fieldData = new HashMap<String, Object>();
        exceptionInformation = new HashMap<String, Object>();
        mdc = event.getProperties();
        ndc = event.getNDC();

        JsonLogObj obj = new JsonLogObj();		
        obj.setHostname(getHostName());
        obj.setMsg(event.getRenderedMessage());
        obj.setTimestamp(event.getTimeStamp());
        obj.setThread(event.getThreadName());
        if(event.getThrowableInformation() != null) {
            final ThrowableInformation throwableInformation = event.getThrowableInformation();
            if(throwableInformation.getThrowable().getClass().getCanonicalName() != null){
                exceptionInformation.put("exception_class",throwableInformation.getThrowable().getClass().getCanonicalName());
            }
            if(throwableInformation.getThrowable().getMessage() != null) {
                exceptionInformation.put("exception_message",throwableInformation.getThrowable().getMessage());
            }
            if( throwableInformation.getThrowableStrRep() != null) {
                String stackTrace = StringUtils.join(throwableInformation.getThrowableStrRep(),"\n");
                exceptionInformation.put("stacktrace",stackTrace);
            }
            addFieldData("exception",exceptionInformation);
        }


        if(event.locationInformationExists()) {
            info = event.getLocationInformation();
            addFieldData("file",info.getFileName());
            addFieldData("line_number",info.getLineNumber());
            addFieldData("class",info.getClassName());
            addFieldData("method",info.getMethodName());
        }

        addFieldData("mdc",mdc);
        addFieldData("ndc",ndc);
        addFieldData("level",event.getLevel().toString());

        obj.setExceptionInformation(exceptionInformation);
        obj.setFieldData(fieldData);        
        return gson.toJson(obj);
	}

	@Override
	public boolean ignoresThrowable() {
		return false;
	}
	
	private String getHostName() {
		 InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return addr.getHostName();
	}
	
	 private void addFieldData(String keyname, Object keyval){
	        if(null != keyval){
	            fieldData.put(keyname, keyval);
	        }
	    }
}
