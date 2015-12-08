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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}


