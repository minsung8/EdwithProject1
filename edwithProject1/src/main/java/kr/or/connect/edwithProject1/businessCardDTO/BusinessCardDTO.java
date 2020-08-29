package kr.or.connect.edwithProject1.businessCardDTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BusinessCardDTO {
	
	String name;
	String phone;
	String companyName;
	Timestamp createDate;
	
	public BusinessCardDTO() {}
	public BusinessCardDTO(String name, String phone, String companyName) {
		super();
		this.name = name;
		this.phone = phone;
		this.companyName = companyName;
	}
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	@Override
	public String toString() {
		return "BusinessCardDTO [name=" + name + ", phone=" + phone + ", companyName=" + companyName + ", createDate="
				+ createDate + "]";
	}
	
	
}
