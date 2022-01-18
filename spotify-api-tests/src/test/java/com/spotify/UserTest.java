package com.spotify;
import org.testng.annotations.Test;
import com.spotify.data.TestUtilities;
import com.spotify.oauth2.RequestSpec;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.spotify.oauth2.ResponseSpec.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest extends RequestSpec {

	@Test
	public void getCurrentUserProfile() {

		given().spec(super.getRequestSpecifiation())
		.when()
		.get("/me")
		.then().spec(getResponseSpecification(200))
		.assertThat()
		.contentType(ContentType.JSON)
		.body("type", equalTo("user"));
	}
	
	@Test
	public void getUserProfile() {
		String userId = "serhatyuna_";
		Response res = given().spec(super.getRequestSpecifiation())
		.pathParam("user_id", userId)
		.get("/users/{user_id}")
		.then().spec(getResponseSpecification(200))
		.extract()
		.response();
		
		assertThat(res.path("display_name"), equalTo("serhatyuna"));
		assertThat(res.path("id"), equalTo("serhatyuna_"));
		assertThat(res.path("type"), equalTo("user"));
	}
	
	@Test (dataProvider = "playlist", dataProviderClass = TestUtilities.class)
	public void followPlaylist (String playlist) {
		
		given().spec(super.getRequestSpecifiation())
		.pathParam("playlistId", playlist)
		.when()
		.put("/playlists/{playlistId}/followers")
		.then().spec(getResponseSpecification(200));
	}
	
	@Test (dataProvider = "artist", dataProviderClass = TestUtilities.class)
	public void followArtist (String type, String id) {
		
		given().spec(super.getRequestSpecifiation())
		.queryParam("type", type)
		.queryParam("ids", id)
		.when()
		.put("me/following")
		.then().spec(getResponseSpecification(204));		
	}
	
	@Test (dataProvider = "checkArtists", dataProviderClass = TestUtilities.class)
	public void checkArtistFollow(String type, String id, Boolean [] follow) {
		
	 Response res = given().spec(super.getRequestSpecifiation())
		.queryParam("type", type)
		.queryParam("ids", id)
		.when()
		.get("/me/following/contains")
		.then().spec(getResponseSpecification(200))
        .extract()
        .response();
	 
	 List <Boolean> resList = res.path("");
	 assertThat(resList, hasSize(follow.length));
	 assertThat(resList,contains(follow));
	 
	}
	
	@Test (dataProvider = "playlist", dataProviderClass = TestUtilities.class)
	public void getCurrentUserPlaylist (String playlist) {
		
	Response res = given().spec(super.getRequestSpecifiation())
		.when()	
		.get("/me/playlists")
		.then().spec(getResponseSpecification(200))
		.extract()
		.response();
	
	List <Object> ids = res.path("items.id");
	assertThat(ids, hasItems(playlist));
	
	}		
}
