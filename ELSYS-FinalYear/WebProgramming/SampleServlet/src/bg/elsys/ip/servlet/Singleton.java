package bg.elsys.ip.servlet;

import java.util.HashMap;
import javax.servlet.http.Cookie;

public class Singleton {
	
	private static Singleton instance;
	public HashMap<Cookie, UserIdentification> users = new HashMap<>();
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
