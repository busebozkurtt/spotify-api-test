package com.spotify.oauth2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
	
	RequestSpecification requestSpecification;
	String baseUrl = "https://api.spotify.com";
	String basePath = "/v1";
	String access_token = "BQBpM7oa_gIhOq-ggvSCxgIeMH5g2hV-zuDy5lGVAoIEAL8ljiDC7kIzix4pknKma8xY_6oTLrr0vSD3AMK_Kqhmtb6IapBqd_eyCbSIfniezS3GfyTljlBuXUlVAvKDSg980njHSblyKJmKM6nABAdQ5mAQBl1CTZjV3o3qMyNH2iNWR3K0SL6smlQ-ou77l4AzVoFR_Lgv7-M9ppCnZQuRu7ErC6GpGEOLqqEnvQp9tHjm30WEQLkl6qO92WxEp78q2B6Ch2xOWbxvL80ahOcu4xvWew";
	
	public RequestSpecification getRequestSpecifiation() {
		return new RequestSpecBuilder().
				addHeader("Authorization","Bearer " + access_token)
				.setBaseUri(baseUrl)
				.setBasePath(basePath)
				.setContentType("application/json")
				.log(LogDetail.ALL)
				.build();
	}
	

}
