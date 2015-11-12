package hello;

import org.springframework.data.annotation.Id;

public class Track {
	@Id
    private String id;
	private String bandName;
	private String albumName;
    private String trackName;
    private String lyrics;
    

    

    public Track() {}

    public Track(String trackName, String lyrics) {
        this.trackName = trackName;
        this.lyrics = lyrics	;
    }

    @Override
    public String toString() {
        return String.format(
                "Track[id=%s, trackName='%s', lyrics='%s']",
                id, trackName, lyrics);
    }

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
}


