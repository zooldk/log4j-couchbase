package dk.braintrust.os.logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Utils {

	public static String getHostName() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addr.getHostName();
	}
}
