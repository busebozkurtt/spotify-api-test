package com.spotify.data;

import org.testng.annotations.DataProvider;


public class TestUtilities{

	@DataProvider(name = "playlist")
	public static Object[][] followPlaylist() {
		 
		return new Object[][] {
			{"2BG9A1a0YFM7jKSFoHkFO9"},
			{"5qrXwgrrqFvQJNRGefqdzy"},
			{"6AB5oYoywOMFD9S8XzdvwE"},
		};
	}
	
	@DataProvider (name = "artist")
	public static Object[][] followArtist(){
		return new Object [][] {
			{"artist", "0Vw76uk7P8yVtTClWyOhac"},
			{"artist", "4dpARuHxo51G3z768sgnrY"},
			{"artist", "6nB0iY1cjSY1KyhYyuIIKH"}
		};
	}
	
	@DataProvider(name = "checkArtists")
	public static Object[][] checkArtist(){
		return new Object [][] {
			{"artist", "0Vw76uk7P8yVtTClWyOhac",new Boolean[] {true}},
			{"artist", "4dpARuHxo51G3z768sgnrY,7dGJo4pcD2V6oG8kP0tJRR", new Boolean[] {true, false}},
			{"artist", "6nB0iY1cjSY1KyhYyuIIKH,6VuMaDnrHyPL1p4EHjYLi7", new Boolean[] {true, false}},
			{"artist", "1Xyo4u8uXC1ZmMpatF05PJ", new Boolean[] {false}},
		};
		
	}
	
	@DataProvider (name = "addTrack")
	public static Object[][] addTrack(){
		return new Object [][] {
			{"27Mp1HAFIhnLBsGXdFcGXG"},
			{"3HAsf0o0TJY9WL4zKCzE3u"},
			{"6ZzYETKetIfNUsZUb23jgG"},
			{"7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B"},
			{"6qYkmqFsXbj8CQjAdbYz07,5xTtaWoae3wi06K5WfVUUH"},
			{"4IWAyPf1KMq7JCyGeCjTeH"}
			
		};
	}
	
	@DataProvider (name = "savedTrack")
	public static Object[][] savedTrack(){
		return new Object [][] {
			{"27Mp1HAFIhnLBsGXdFcGXG"},
			{"3HAsf0o0TJY9WL4zKCzE3u"},
			{"6ZzYETKetIfNUsZUb23jgG"}
		};
	}
	
	@DataProvider (name = "deletedTrack")
	public static Object[][] deletedTrack(){
		return new Object [][] {
			{"7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B"},
			{"6qYkmqFsXbj8CQjAdbYz07,5xTtaWoae3wi06K5WfVUUH"},
			{"4IWAyPf1KMq7JCyGeCjTeH"}
		};
	}
}
