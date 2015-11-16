package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


public interface ArtistRepo extends MongoRepository<Artists, String> {

    public List<Artists> findByBandName(String bandName);
    public List<Artists> findByLastName(String lastName);

}
