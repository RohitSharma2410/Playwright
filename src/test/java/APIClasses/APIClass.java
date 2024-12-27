package APIClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

public class APIClass {

	public APIRequestContext apiRequestContext = null;
	private String data = null;
	public String endpoint = null;
	public String apiMethod = null;

	public RequestOptions getRo() {
		return ro;
	}

	private RequestOptions ro = null;

	public APIClass(APIRequestContext context, APIS apiName, Properties properties) {
		this.apiRequestContext = context;

		apiMethod = apiName.getMethod();
		endpoint = properties.getProperty("baseURI_endpoint").toString().concat(apiName.getAPIEndpoint());

	}

	public APIResponse callAPI() {
		System.out.println(data);
		System.out.println(endpoint);

		return apiRequestContext.post(endpoint, RequestOptions.create().setMethod(apiMethod).setData(data)
				.setHeader("Content-Type", "application/json"));
	}

	public void updatequeryParam(String name, String value) {

		ro = ro.setQueryParam(name, value);
	}

	public void updateAPIenpoint(String st) {
		this.endpoint = endpoint.concat(st);
	}

	public void setBodyForAPI(String fileName) throws IOException {
		String pathToFile = System.getProperty("user.dir").concat("/apiJsons/") + fileName + ".json";
		data = new String(Files.readAllBytes(Paths.get(pathToFile)));

	}

}
