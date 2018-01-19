package pro05;

public class BookVo {

	private int id;
	private String title;
	private String pubs;
	private String pub_date;
	private String authorName;
	private String state_code;
	
	
	
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public BookVo(String title, String pubs, String pub_date, String authorName, String state_code) {
		super();
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.authorName = authorName;
		this.state_code = state_code;
	}



	public BookVo(int id, String title, String pubs, String pub_date, String authorName, String state_code) {
		super();
		this.id = id;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.authorName = authorName;
		this.state_code = state_code;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPubs() {
		return pubs;
	}



	public void setPubs(String pubs) {
		this.pubs = pubs;
	}



	public String getPub_date() {
		return pub_date;
	}



	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}



	public String getAuthorName() {
		return authorName;
	}



	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	public String getState_code() {
		return state_code;
	}



	public void setState_code(String state_code) {
		this.state_code = state_code;
	}



	@Override
	public String toString() {
		if(state_code.equals("1")) {
			state_code = "재고있음";
		}else if(state_code.equals("0")) {
			state_code = "대여중";
		}
		return "BookVo [id=" + id + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date + ", authorName="
				+ authorName + ", state_code=" + state_code + "]";
	}
	
	
	
	
}
