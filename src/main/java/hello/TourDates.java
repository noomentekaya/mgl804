package hello;

import org.springframework.data.annotation.Id;

public class TourDates {
	@Id
    private String id;
	private String bandName ;
    private String date;
    private String venue;
    private String city ;
    private String country ;

    

    

    public TourDates() {}

    public TourDates(String date, String venue, String city, String country) {
        this.date = date;
        this.venue = venue	;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format(
                "TourDates[id=%s, date='%s', venue='%s',city='%s',country='%s']",
                id, date, venue,city,country);
    }

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}


