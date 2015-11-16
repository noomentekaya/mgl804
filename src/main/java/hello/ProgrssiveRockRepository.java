package hello;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import hello.Album;
import hello.Artists;
import hello.Band;
import hello.TourDates;

public interface ProgrssiveRockRepository extends MongoRepository<Band, String> {

    public Band findByBandName(String bandName);
    public List<Artists> findByLastName(String lastName);
    public List<Album> findAlbumsByBandName(String bandName);
    public List<TourDates> findDateAndPlaceByBandName(String bandName);

}
