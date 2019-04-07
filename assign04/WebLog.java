
public class WebLog {
	String ip;
	String time;
	String url;
	String status;
	
	public WebLog(String ip, String time, String url, String status) {
		this.ip = ip;
		this.time = time;
		this.url = url;
		this.status = status;
	}
	
	public String getIP() {
		return this.ip;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public String getURL() {
		return this.url;
	}
	
	public String getStatus() {
		return this.status;
	}
}
