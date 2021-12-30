package custAnno;

public class Customer {
	String code;
	String name, email, tel;
	String weight;
	
	
	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getTel() {
		return tel;
	}


	public String getWeight() {
		return weight;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Customer [code=" + code + ", name=" + name + ", email=" + email + ", tel=" + tel + ", weight=" + weight
				+ "]";
	}
	
	
}
