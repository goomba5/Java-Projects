package business;

public class Music {
	private int songID;
	private String song;
	private String artist;
	private String album;
	
	public Music(int songID, String song, String artist, String album) {
		super();
		this.songID = songID;
		this.song = song;
		this.artist = artist;
		this.album = album;
	}

	public int getSongID() {
		return songID;
	}

	public void setSongID(int songID) {
		this.songID = songID;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "Music [id=" + songID + ", artist=" + artist + ", album=" + album + ", song=" + song + "]";
	}
	
}
