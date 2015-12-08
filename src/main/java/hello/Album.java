package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Album {
	 @Id
	    private String id;
	 	private String bandName ;
	    private String albumName;
	    private String issued ;
	    private List<Track> tracks ;
	    

	    public Album() {}

	    public Album(String albumName,String issued) {
	        this.albumName = albumName;
	        this.issued = issued ;
	    }
	    

	    public List<Track> getTracks() {
			return (ArrayList)tracks;
		}

		public void setTracks(ArrayList<Track> tracks) {
			this.tracks = tracks;
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

		public String getIssued() {
			return issued;
		}

		public void setIssued(String issued) {
			this.issued = issued;
		}

		public void setTracks(List<Track> tracks) {
			this.tracks = tracks;
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
			Album other = (Album) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
}
