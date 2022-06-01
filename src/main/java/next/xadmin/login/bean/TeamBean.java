package next.xadmin.login.bean;

public class TeamBean {

	private int pid;
	private int uid;
	private String teamname;
	private String playername;
	
	public TeamBean(int pid, int uid, String teamname, String playername) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.teamname = teamname;
		this.playername = playername;
	}
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	
	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

}
