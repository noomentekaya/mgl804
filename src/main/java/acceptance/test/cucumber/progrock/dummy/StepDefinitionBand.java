package acceptance.test.cucumber.progrock.dummy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hello.Album;
import hello.AlbumRepository;
import hello.Application;
import hello.ArtistRepo;
import hello.Artists;
import hello.Band;
import hello.ProgrssiveRockRepository;
import hello.TourDateRepository;
import hello.TourDates;
import hello.Track;
import hello.TrackRepository;

@RunWith(JUnit4.class)
@SpringApplicationConfiguration(classes = Application.class)
public class StepDefinitionBand {
	 private Band band;
	 private Album album ;
	 private Artists artist ;

	 @Autowired
	 ProgrssiveRockRepository pr ;
	 @Autowired
	 AlbumRepository al ;
	 @Autowired
	 ArtistRepo ar ;
	 @Autowired
	 TourDateRepository tr ;
	 @Autowired
	 TrackRepository trepo ;
	 
	 @Given(".+Album with name '(.+)' issued in'(.+)'")
	 public void initalbumforTrack(String albumName, String issued) throws Throwable {
		 	
	        
	        album.setAlbumName(albumName);
		 	album.setIssued(issued);
	        
	    } 
	 @When(".+User search for Track '(.+)'")
	 public Track searchtrack(String trackName){
		 return trepo.findByTrackName(trackName);
	 }
	 @Then(".+track '(.+)' is found in album '(.+)'")
	 public boolean trackFound(String trackName,String albumName){
		 List<Track> tracks = new ArrayList<>();
		 tracks = trepo.findByAlbumName(albumName);
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(searchtrack(trackName).getTrackName(), equalTo(tracks.get(i).getTrackName()));
		i++;
		}
	 }
	 @Given("^Album with name '(.+)' issued in (\\d+)$")
	 public void album_with_name_orchid_issued_in(int arg1) throws Throwable {
		album = new Album("orchid","1995");
	 }

	 @When("^User search for Track '(.+)'$")
	 public void user_search_for_Track_forest_of_october(String trackName) throws Throwable {
		  trepo.findByTrackName(trackName);

	 }

	 @Then("^track forest of octber is found in album '(.+)'$")
	 public void track_forest_of_octber_is_found_in_album_orchid(String trackName) throws Throwable {
		 List<Track> tracks = new ArrayList<>();
		 tracks = trepo.findByAlbumName(album.getAlbumName());
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(searchtrack(trackName).getTrackName(), equalTo(tracks.get(i).getTrackName()));
		i++;
		}
	 }
	 
	 @Given(".+Band with name '(.+)', that plays '(.+)'")
	 public void initBand(String bandName,String genre) throws Throwable {
		 	
	        
	        band.setBandName(bandName);
		 	band.setGenre(genre);
	        
	    }
	 @When(".+User searchs for Artist with name '(.+)'")
	 public Artists searchArtist(String name){
		 return ar.findByLastName(name);
	 }
	 @Then("Artist should be found with name '(.+)' that plays for '(.+)'")
	 public boolean artistFound(String name , String bandName){
		 Band b = new Band();
		b = pr.findByBandName(bandName);
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(b.getArtists().get(i), equalTo(searchArtist(name)));
		i++;
		}
	 }
	 
	 
	@Given(".+Album with name '(.+)', that was issued in '(.+)'")
	 public void initAlbum(String albumName, String issued) throws Throwable {
		 
	        album = new Album(albumName, issued);
	        
	    }
	@When(".+User search for Band '(.+)'")
	public List<Album> searchAlbum (String bandName){
		return al.findByBandName(bandName);
	}
	 @Then("Album '(.+)' Should be in '(.+)' album list")
	 public boolean albumFound(String albumName,String bandName){
		 	Album album = new Album();
			album= al.findByAlbumName(albumName);
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(album, equalTo(searchAlbum(bandName).get(i)));
			i++;
			}
			}
	 
	 @Given(".+ Tour date in City '(.+)'")
	 public TourDates initTourDate(String city) throws Throwable {
		 TourDates td = new TourDates();
		 td.setCity(city);
		 return td;
	    }
	 @When(".+User searchs for band '(.+)' tour date")
		public List<TourDates> searchTourDates (String bandName){
			return tr.findByBandName(bandName);
		}
	 @Then(".+ TourDate '(.+)' is Found")
	 public void tourDateFound(String city) throws Throwable{
		 TourDates tds = new TourDates();
			tds= tr.findByCity(initTourDate(city).getCity());
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(tds.getDate(), equalTo(searchTourDates(city).get(i).getDate()));
			i++;
			}
	 }
	
	 
	@Given("^Album with name '(.+)' issued in (\\d+)$")
	 public void album_with_name_Watershed_issued_in(int arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	        album = new Album("Watershed", "2008");


	 }

	 @When("^User search for Band '(.+)'$")
	 public List<Album> user_search_for_Band_Opeth() throws Throwable {
		 return al.findByBandName("Opeth");
		 }

	 @Then("^Album '(.+)' Should be in '(.+)' album list$")
	 public void album_Still_life_Should_be_in_Opeth_album_list(String album,String band) throws Throwable {
			Album albumm = new Album();
			albumm= al.findByAlbumName(album);
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(albumm, equalTo(searchAlbum(band).get(i)));
			i++;
			}
	 }

	 @Given("^Band with name '(.+)' that plays '(.+)'$")
	 public void band_with_name_Opeth_that_plays_prog_rock(String bandName,String genre) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 band = new Band();
		 band.setBandName(bandName);
		 	band.setGenre(genre);
	 }

	 @When("^User searchs for Artist with name '(.+)'$")
	 public Artists user_searchs_for_Artist_with_name_Mikael(String name) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		return ar.findByLastName(name);

	 }

	 @Then("^Artist should be found with name '(.+)' that plays for '(.+)'$")
	 public Boolean artist_should_be_found_with_name_Mikael_that_plays_for_Opeth(String name, String bandName) throws Throwable {

		 Band b = new Band();
			b = pr.findByBandName(bandName);
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(b.getArtists().get(i), equalTo(searchArtist(name)));
			i++;
			}	     
	 }

	 @Given("^Tour date in City '(.+)'$")
	 public TourDates tour_date_in_City_Montreal(String city) throws Throwable {
		 TourDates td = new TourDates();
		  td.setCity(city);
		  return td ;
	 }

	 @When("^User searchs for band '(.+)' tour date$")
	 public List<TourDates> user_searchs_for_band_King_Crimson_tour_date(String bandName) throws Throwable {
	     return tr.findByBandName(bandName);
	 }

	 @Then("^TourDate (\\d+)/(\\d+)/(\\d+) in city '(.+)' is Found$")
	 public boolean tourdate_is_Found(int arg1, int arg2, int arg3,String city) throws Throwable {
	     TourDates tds = new TourDates();
			tds= tr.findByCity(city);
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(tds.getDate(), equalTo(searchTourDates(city).get(i).getDate()));
			i++;
			}
	 }
	 
}
