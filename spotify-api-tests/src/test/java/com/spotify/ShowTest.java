package com.spotify;
import com.spotify.oauth2.RequestSpec;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.spotify.oauth2.ResponseSpec.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShowTest extends RequestSpec{
	
	String showId = "7mPYdMnKMESL3gAhzzXIVE";
	int limit = 5;
    int offset = 3;

	@Test
	public void getSeveralShow() {
		
		Response res = given().spec(super.getRequestSpecifiation())
		.queryParam("ids", showId)
		.when()
		.get("/shows")
		.then().spec(getResponseSpecification(200))
		.assertThat()
		.contentType(ContentType.JSON)
		.extract()
		.response();
		
		assertThat(res.path("shows[0].id"), equalTo(showId));
	}

	@Test
	public void getShowEpisodes() {
		
		Response res = given().spec(super.getRequestSpecifiation())
			.pathParam("id", showId)
			.queryParam("limit", limit)
            .queryParam("offset", offset)
			.when()
			.get("/shows/{id}/episodes")
			.then().spec(getResponseSpecification(200))
			.assertThat()
			.contentType(ContentType.JSON)
			.extract()
			.response();
		
		assertThat(res.path("limit"), is(equalTo(limit)));
        assertThat(res.path("offset"), is(equalTo(offset)));
	}
}
