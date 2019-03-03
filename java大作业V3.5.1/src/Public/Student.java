package Public;

public class Student implements Comparable<Student>{
	private String name;
	private String num;
	private String politics;
	private String sex;
	private String Clas;
	private String age;
	private String tel;
	private String QQ;
	private String address;
	private String Native;
	private String Img;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getNum() {
		return num;
	}
	public void setPolitics(String politics) {
		this.politics = politics;
	}
	public String getPolitics() {
		return politics;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setClas(String clas) {
		Clas = clas;
	}
	public String getClas() {
		return Clas;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAge() {
		return age;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getQQ() {
		return QQ;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setNative(String native1) {
		Native = native1;
	}
	public String getNative() {
		return Native;
	}
	public void setImg(String img) {
		Img = img;
	}
	public String getImg() {
		return Img;
	}
		
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (num.compareTo(o.num)>0) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
}
