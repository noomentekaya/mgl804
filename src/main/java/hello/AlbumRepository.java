package hello;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {

    public List<Album> findByBandName (String  bandName);
    
   

}
