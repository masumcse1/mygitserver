package org.meveo.api.git;

public class GitRepository {
	
	Long ID;
	   String code;
	   
	   
	   
	   
	   
	public GitRepository() {
		super();
		ID=Long.parseLong("1");
		code="customer";
		
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	   
	   

}
