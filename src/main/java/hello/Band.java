package hello;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


public class Band {

    @Id
    private String id;

    private String bandName;
    private String genre;
    private List<Album> albums;
   
    private List<Artists> artists;
    
    
    private List<TourDates> dateAndPlace ;

    public Band() {}

    public Band(String bandName, String genre) {
        this.bandName = bandName;
        this.genre = genre;
    }

    
    public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Artists> getArtists() {
		return artists;
	}

	public void setArtists(List<Artists> artists) {
		this.artists = artists;
	}

	public List<TourDates> getDateAndPlace() {
		return dateAndPlace;
	}

	public void setDateAndPlace(List<TourDates> dateAndPlace) {
		this.dateAndPlace = dateAndPlace;
	}

	@Override
    public String toString() {
        return String.format(
                "Band[id=%s, bandName='%s', genre='%s',albums='%s']",
                id, bandName, genre,albums);
    }

}
