package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import business.Music;

public class MusicDB {
	// create connection object to SQL
	private Connection getConnection() throws SQLException {
			
			String dbURL = "jdbc:mysql://localhost:3306/music_db";
			String username = "dj";
			String password = "passmeby";
			Connection connection = DriverManager.getConnection(dbURL,
									username, password);
			return connection;
		} // Connection closing brace
	
	// create getAll method
	public List<Music> getAllMusic() throws SQLException {
		List<Music> music = new ArrayList<>();
		
		Connection connect = getConnection();
		String sql = "SELECT * FROM Music";
		PreparedStatement ps = connect.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
				
				// process each of the entries
				int musicID = rs.getInt(1);
				String artist = rs.getString(2);
				String album = rs.getString(3);
				String song = rs.getString(4);
				Music m = new Music(musicID, artist, album, song);
				
				// add the entry to the list
				music.add(m);
		}
		return music;
	}
	
	// create add method
	public boolean addSong(Music m) throws SQLException{
			
			Connection connect = getConnection();
			boolean successful = false;
			
			// create SQL query string
			String query = "INSERT INTO Music" +
					   "(songID, Song, Artist, Album)" +
					   "VALUES(?, ?, ?, ?)";
			
			PreparedStatement ps = connect.prepareStatement(query);
			// prepared statements
			ps.setInt(1, m.getSongID());
			ps.setString(2, m.getSong());
			ps.setString(3, m.getArtist());
			ps.setString(4, m.getAlbum());
			
			int rowCount = ps.executeUpdate();
			
			if(rowCount > 0) {
				successful = true;
			}
			
			
			return successful;
		}
	
	// shuffle method
	public void shufflePlaylist() throws SQLException{
		List<Music> music = new ArrayList<>();
		
		Connection connect = getConnection();
		String sql = "SELECT * FROM Music";
		PreparedStatement ps = connect.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			// process each of the entries
			// math random to songID
			
			// add to the list
			int songID = rs.getInt(1);
			String song = rs.getString(2);
			String artist = rs.getString(3);
			String album = rs.getString(4);
			Music m = new Music(songID, song, artist, album);
			
			// add the entry to the list
			music.add(m);
			}
		
		int size = music.size();
		Collections.shuffle(music);
		
			for(Music s: music) {
				System.out.println(s.getSongID() + ": " + s.getSong() + "\t"+  
								   s.getArtist() + "\t" + s.getAlbum());
				}
//		return music;
	}
	
	// create delete method
	public boolean deleteSong(Music m) throws SQLException {
		Connection connect = getConnection();
		boolean successful = false;
		
		String query = "DELETE FROM Music WHERE songID = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		// prepared statements
		ps.setInt(1, m.getSongID());
		int rowCount = ps.executeUpdate();
		
		if(rowCount > 0) {
			successful = true;
		}
		
		return successful;
	}
}
