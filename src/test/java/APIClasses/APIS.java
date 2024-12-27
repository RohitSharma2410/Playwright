package APIClasses;

public enum APIS {

	Login("api/login", "post"), Createuser("api/users", "post"), Delete("api/users/", "Delete");

	String name;
	String method;

	APIS(String name, String methodType) {
		this.name = name;
		this.method = methodType;
	}

	public String getAPIEndpoint() {
		return this.name;
	}

	public String getMethod() {
		return this.method;
	}
}
