package dk.braintrust.os.logger;

import org.apache.log4j.Logger;

/**
 * 
 * @author slarsen
 *
 */
public class TestCouchBaseAppender {

	 public static class LogThread extends Thread {
	        Logger log = Logger.getLogger("COUCHBASE");
	        public void run() {
	            for (long i = 0; i < 10000; i++)
	                log.warn("whatever " + i);
	        }
	    }
	    
	    static Logger log = Logger.getLogger("COUCHBASE");
	    
	    public static void main(String[] args) {
	        for (int i = 1; i <= 9; i++) {
	            new TestCouchBaseAppender.LogThread().start();
	        }
	        
	        for (long i = 0; i < 10; i++) {
	            log.error("that's me " + i);
	        }
	    }
}
