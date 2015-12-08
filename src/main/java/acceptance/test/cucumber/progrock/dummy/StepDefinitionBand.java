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
	 public void initalbumforTrack() throws Throwable {
		 	
	        
	        album.setAlbumName("orchid");
		 	album.setIssued("1995");
	        
	    } 
	 @When(".+User search for Track '(.+)'")
	 public Track searchtrack(){
		 return trepo.findByTrackName("forest of october");
	 }
	 @Then(".+track '(.+)' is found in album '(.+)'")
	 public boolean trackFound(){
		 List<Track> tracks = new ArrayList<>();
		 tracks = trepo.findByAlbumName(album.getAlbumName());
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(searchtrack().getTrackName(), equalTo(tracks.get(i).getTrackName()));
		i++;
		}
	 }
	 @Given("^Album with name orchid issued in (\\d+)$")
	 public void album_with_name_orchid_issued_in(int arg1) throws Throwable {
		album = new Album("orchid","1995");
	 }

	 @When("^User search for Track forest of october$")
	 public void user_search_for_Track_forest_of_october() throws Throwable {
		  trepo.findByTrackName("forest of october");

	 }

	 @Then("^track forest of octber is found in album orchid$")
	 public void track_forest_of_octber_is_found_in_album_orchid() throws Throwable {
		 List<Track> tracks = new ArrayList<>();
		 tracks = trepo.findByAlbumName(album.getAlbumName());
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(searchtrack().getTrackName(), equalTo(tracks.get(i).getTrackName()));
		i++;
		}
	 }
	 
	 @Given(".+Band with name '(.+)', that plays '(.+)'")
	 public void initBand() throws Throwable {
		 	
	        
	        band.setBandName("Opeth");
		 	band.setGenre("prog rock");
	        
	    }
	 @When(".+User searchs for Artist with name '(.+)'")
	 public Artists searchArtist(){
		 return ar.findByLastName("Mikael");
	 }
	 @Then("Artist should be found with name '(.+)' that plays for '(.+)'")
	 public boolean artistFound(){
		 Band b = new Band();
		b = pr.findByBandName(band.getBandName());
		boolean loop = false ;
		int i = 0 ;
		while(!false){
		assertThat(b.getArtists().get(i), equalTo(searchArtist()));
		i++;
		}
	 }
	 
	 
	@Given(".+Album with name '(.+)', that was issued in '(.+)'")
	 public void initAlbum() throws Throwable {
		 
	        album = new Album("Watershed", "2008");
	        
	    }
	@When(".+User search for Band '(.+)'")
	public List<Album> searchAlbum (){
		return al.findByBandName("Opeth");
	}
	 @Then("Album '(.+)' Should be in '(.+)' album list")
	 public boolean albumFound(){
		 	Album album = new Album();
			album= al.findByAlbumName("Still life");
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(album, equalTo(searchAlbum().get(i)));
			i++;
			}
			}
	 
	 @Given(".+ Tour date in City '(.+)'")
	 public TourDates initTourDate() throws Throwable {
		 TourDates td = new TourDates();
		 td.setCity("Montreal");
		 return td;
	    }
	 @When(".+User searchs for band '(.+)' tour date")
		public List<TourDates> searchTourDates (){
			return tr.findByBandName("King Crimson");
		}
	 @Then(".+ TourDate '(.+)' is Found")
	 public void tourDateFound() throws Throwable{
		 TourDates tds = new TourDates();
			tds= tr.findByCity(initTourDate().getCity());
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(tds.getDate(), equalTo(searchTourDates().get(i).getDate()));
			i++;
			}
	 }
	
	 
	 @Given("^Album with name Watershed issued in (\\d+)$")
	 public void album_with_name_Watershed_issued_in(int arg1) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	        album = new Album("Watershed", "2008");


	 }

	 @When("^User search for Band Opeth$")
	 public List<Album> user_search_for_Band_Opeth() throws Throwable {
		 return al.findByBandName("Opeth");
		 }

	 @Then("^Album Still life Should be in Opeth album list$")
	 public void album_Still_life_Should_be_in_Opeth_album_list() throws Throwable {
			Album album = new Album();
			album= al.findByAlbumName("Still life");
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(album, equalTo(searchAlbum().get(i)));
			i++;
			}
	 }

	 @Given("^Band with name Opeth that plays prog rock$")
	 public void band_with_name_Opeth_that_plays_prog_rock() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 band = new Band();
		 band.setBandName("Opeth");
		 	band.setGenre("prog rock");
	 }

	 @When("^User searchs for Artist with name Mikael$")
	 public Artists user_searchs_for_Artist_with_name_Mikael() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		return ar.findByLastName("Mikael");

	 }

	 @Then("^Artist should be found with name Mikael that plays for Opeth$")
	 public Boolean artist_should_be_found_with_name_Mikael_that_plays_for_Opeth() throws Throwable {

		 Band b = new Band();
			b = pr.findByBandName(band.getBandName());
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(b.getArtists().get(i), equalTo(searchArtist()));
			i++;
			}	     
	 }

	 @Given("^Tour date in City Montreal$")
	 public TourDates tour_date_in_City_Montreal() throws Throwable {
		 TourDates td = new TourDates();
		  td.setCity("Montreal");
		  return td ;
	 }

	 @When("^User searchs for band King Crimson tour date$")
	 public List<TourDates> user_searchs_for_band_King_Crimson_tour_date() throws Throwable {
	     return tr.findByBandName("King Crimson");
	 }

	 @Then("^TourDate (\\d+)/(\\d+)/(\\d+) is Found$")
	 public boolean tourdate_is_Found(int arg1, int arg2, int arg3) throws Throwable {
	     TourDates tds = new TourDates();
			tds= tr.findByCity(initTourDate().getCity());
			boolean loop = false ;
			int i = 0 ;
			while(!false){
			assertThat(tds.getDate(), equalTo(searchTourDates().get(i).getDate()));
			i++;
			}
	 }
	 
}
