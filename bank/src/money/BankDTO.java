package money;

public class BankDTO {
	private String id;
	private String name;
	private int age;
	private String tel;
	private int count;
	private int idcount;
	

	public BankDTO(){
		
	}
	
	public int getIdcount() {
		return idcount;
	}
	
	public void setIdcount(int idcount) {
		this.idcount = idcount;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
