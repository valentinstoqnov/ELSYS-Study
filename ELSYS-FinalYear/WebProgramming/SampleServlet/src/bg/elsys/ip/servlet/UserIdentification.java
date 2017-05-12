package bg.elsys.ip.servlet;

public class UserIdentification {
	
	private String ipAddress;
	private String date;
	
	public UserIdentification(String ipAddress, String date) {
		super();
		this.ipAddress = ipAddress;
		this.date = date;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
