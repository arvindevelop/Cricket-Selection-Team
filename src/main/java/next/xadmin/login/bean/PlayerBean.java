package next.xadmin.login.bean;

public class PlayerBean {

	private int pid;
	private String playername;
	private double rating;
	
	public PlayerBean(int pid, String playername, double rating) {
		super();
		this.pid = pid;
		this.playername = playername;
		this.rating = rating;
	}
	
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPlayername() {
		return playername;
	}


	public void setPlayername(String playername) {
		this.playername = playername;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	

	
}
