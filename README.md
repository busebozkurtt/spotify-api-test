# Spotify API Test 
In the project, the api test of the spotify application was made. Before starting the project, a new app should be created by following the steps on https://developer.spotify.com/documentation/general/guides/authorization/app-settings/.          

After the app is created, authorization should be done by following the names on the https://developer.spotify.com/documentation/general/guides/authorization/ page. 

Scopes should be selected by referencing the https://developer.spotify.com/documentation/general/guides/authorization/scopes/ page while authorizing.

>Socopes selected in this project:
- user-read-playback-position
- user-library-modify
- user-library-read
- user-read-email
- playlist-modify-private
- playlist-read-collaborative
- user-follow-modify
- user-follow-read

Access token obtained after these steps should be changed in the \src\main\java\com\spotify\spec directory in the project.

>Functions tested in the project:
- Get Several Shows
- Get Show Episodes
- Save Tracks for Current User
- Remove Tracks for Current User
- Get User's Saved Tracks
- Get Current User's Profile
- Follow Playlist
- Get Current User's Playlists
- Follow Artists or Users
- Check If User Follows Artists or Users
- Get User's Profile
