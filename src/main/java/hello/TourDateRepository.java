package hello;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import hello.TourDates;

public interface TourDateRepository extends MongoRepository<TourDates, String> {

    public List<TourDates> findByBandName(String bandName);
    public TourDates findByCity(String city);

}
