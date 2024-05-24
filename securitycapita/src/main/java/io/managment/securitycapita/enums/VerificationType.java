package io.managment.securitycapita.enums;

public enum VerificationType {
	
	ACCOUNT("ACCOUNT"),
	PASSWORD("PASSWORD");
	
	private final String type;
	
	VerificationType(String type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	
	public String getType() {
		return this.type.toLowerCase();
	}
	
}

	