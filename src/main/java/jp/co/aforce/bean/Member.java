package jp.co.aforce.bean;

import java.util.List;

public class Member {
	private String id;
	private String address;
	private String phone;
	private String mail;
	private String pass;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
        
		this.address=address ;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		 if (phone.length() > 11) {
		        throw new IllegalArgumentException("Phone number must be 11 digits or less.");
		    }
		this.phone=phone ;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail=mail ;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass ;
	}


	private List<String> addressList; // 追加したプロパティ
	
	// 他のプロパティとgetter, setterの定義
	
	public List<String> getAddressList() {
		return addressList;
	}
	
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
}


