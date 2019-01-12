package ui;

import java.sql.SQLException;
import java.util.List;

import business.Music;
import db.MusicDB;
import util.Console;

public class IPodMusicApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("You found a dusty pink iPod Mini\n");
		
		Console console = new Console();
		
		MusicDB mdb = new MusicDB();
		
		String decision = "y";
		int choice = 0;
		
		// turn on iPod
		decision = console.getString("Turn on the iPod Mini? ");
		
		if(decision.equalsIgnoreCase("y")) {
			
			while(choice != 5) {
				
				// get the menu
				getIpodMenu();
				
				// retrieve user input
//				System.out.println(); // new line for space
				choice = console.getInt("Choose an option: ");
				
				// list of options
				if(choice == 1) {
					try {
						System.out.println(); // new line for space
						System.out.println("CURRENT LIST OF SONGS");
						List<Music> songs = mdb.getAllMusic();
						for(Music m: songs) {
							int songID = m.getSongID();
							String song = m.getSong();
							String artist = m.getArtist();
							String album = m.getAlbum();
							
							System.out.println(songID + ": " + song + "\t"+  artist + "\t" + album);
							
						}
					} catch (SQLException e) {
						System.out.println("Exception occurred getting all of the songs.");
						e.printStackTrace();
					}
					System.out.println(); // new line for space
				}
				
				// add new song
				else if(choice == 2) {
					// prompt user for song
					String song = console.getString("Enter the song title: ");
					String artistName = console.getString("Enter the artist's name: ");
					String albumTitle = console.getString("Enter the album title: ");
					
					// add new customer to Customer object
					Music m = new Music(0, song, artistName, albumTitle);
					
					// within try-catch, print that the customer was successfully added
					try {
						if(mdb.addSong(m)) {
							System.out.println(m.getSong() + " by " + m.getArtist()+ 
											   " was added to your library!");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Error adding song to library.");
						e.printStackTrace();
					}
					System.out.println(); // new line for space
				}
				
				// shuffle playlist
				else if(choice == 3) {
					try {
						System.out.println(); // new line for space
						System.out.println("SHUFFLED PLAYLIST");
						mdb.shufflePlaylist();
					} catch (SQLException e) {
						System.out.println("Exception occurred getting all of the songs.");
						e.printStackTrace();
					}
					System.out.println(); // new line for space
				}
				
				// delete a song
				else if(choice == 4) {
					
					int songChoice = console.getInt("Enter song ID you want to remove: ");
					
					try {
					List<Music> songs = mdb.getAllMusic();
					for(Music m: songs) {
						if(songChoice == m.getSongID()) {
							if(mdb.deleteSong(m)) {
								System.out.println(); // new line for space
								System.out.println(m.getSong() + 
												   " was deleted from your library.");
							}
						}
					}
				}
					catch (SQLException e) {
						System.out.println("Exception occurred while deleting the chosen song.");
						e.printStackTrace();
					}
				}
				System.out.println(); // new line for space
			}
			System.out.println(); // new line for space
			System.out.println("Baby, come back!");
		}
		else {
			System.out.println(); // new line for space
			System.out.println("Nah. You have better things to do anyways.");
		}
	}
	
	private static void getIpodMenu() {
		System.out.println("DUSTY IPOD MENU");
		System.out.println("1 - View All Music");
		System.out.println("2 - Add New Music");
		System.out.println("3 - Shuffle Playlist");
		System.out.println("4 - Remove a Song");
		System.out.println("5 - Turn Off iPod Mini");
	}

}
