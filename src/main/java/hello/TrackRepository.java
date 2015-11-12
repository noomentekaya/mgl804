package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepository extends MongoRepository<Track, String> {

    public List<Track> findByBandName(String bandName);
    public List<Track> findByAlbumName(String trackName);

   

}
