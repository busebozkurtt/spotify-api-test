package com.spotify;
import com.spotify.oauth2.RequestSpec;
import org.testng.annotations.Test;
import com.spotify.data.TestUtilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.spotify.oauth2.ResponseSpec.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TrackTest extends RequestSpec {
	
	@Test (dataProvider = "addTrack", dataProviderClass = TestUtilities.class, priority=1)
	public void saveTracks(String trackId) {
		
		given().spec(super.getRequestSpecifiation())
				.queryParam("ids", trackId)
				.when()
				.put("/me/tracks")
				.then().spec(getResponseSpecification(200));
	}
	
	@Test (dataProvider = "deletedTrack", dataProviderClass = TestUtilities.class, priority=2)
	public void removeTracks(String trackId) {
		
		given().spec(super.getRequestSpecifiation())
				.queryParam("ids", trackId)
				.when()
				.delete("/me/tracks")
				.then().spec(getResponseSpecification(200));
	}

	@Test (dataProvider = "savedTrack", dataProviderClass = TestUtilities.class, priority=3)
	public void getUserSavedTracks(String trackId) {
		
		Response res = given().spec(super.getRequestSpecifiation())
				.when()
				.get("/me/tracks")
				.then().spec(getResponseSpecification(200))
				.assertThat()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		
		List <Object> ids = res.path("items.track.id");
		assertThat(ids, hasItems(trackId));
		
	}

}
