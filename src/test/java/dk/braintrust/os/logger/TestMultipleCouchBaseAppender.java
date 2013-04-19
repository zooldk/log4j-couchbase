package dk.braintrust.os.logger;

import junit.framework.Test;
import junit.framework.TestResult;

import org.apache.log4j.Logger;

/**
 * 
 * @author slarsen
 * 
 */
public class TestMultipleCouchBaseAppender {

	public static class LogThread extends Thread {
		Logger log = Logger.getLogger(TestMultipleCouchBaseAppender.class);

		public void run() {
			for (long i = 0; i < 10000; i++)
				log.warn("whatever " + i);
		}
	}

	static Logger log = Logger.getLogger(TestMultipleCouchBaseAppender.class);

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			new TestMultipleCouchBaseAppender.LogThread().start();
		}

		for (long i = 0; i < 10; i++) {
			log.error("that's me " + i);
		}
	}

	public int countTestCases() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void run(TestResult arg0) {
		
	}
}
