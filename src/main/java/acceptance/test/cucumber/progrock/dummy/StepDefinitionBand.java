package acceptance.test.cucumber.progrock.dummy;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hello.Album;
import hello.AlbumRepository;
import hello.Application;
import hello.ArtistRepo;
import hello.Artists;
import hello.Band;
import hello.ProgrssiveRockRepository;
@ContextConfiguration("cucumber.xml")
public class StepDefinitionBand {
	 private Band band;
	 private Album album ;
	 private Artists artist ;
	 Application app = new Application() ;
	
	 
	 @Given(".+Band with name '(.+)', that plays '(.+)'")
	 public void initBand() throws Throwable {
		 	
	        
	        band.setBandName("Opeth");
		 	band.setGenre("prog rock");
	        
	    }
	 @Then("Band '(.+)' saved!")
	 public void saveBand(){
		 app.getRepository().save(band);
	 }
	 
	 
	 @Given(".+Album with name '(.+)', that was issued in '(.+)'")
	 public void initAlbum() throws Throwable {
		 
	        album = new Album("Watershed", "2008");
	        
	    }
	 @Then("Album '(.+)' saved!")
	 public void saveAlbum(){
		 app.getAlbumprepo().save(album);
	 }
	 
	 @Given(".+Artist with firstName Mikael '(.+)'and lastName '(.+)'  as '(.+)' player for band '(.+)'")
	 public void initArtist() throws Throwable {
		 artist.setFirstName("Mikael");
		 artist.setLastName("Akerfeldt");
		 artist.setBandName("Opeth");
		 artist.setInstrument("guitar");
		 
	    }
	 @Then("Artist '(.+)' '(.+)' saved!")
	 public void saveArtist(){
		 app.getArtistRepo().save(artist);
	 }
	
	 
	 @Given("^Album with name Watershed issued in (\\d+)$")
	 public void album_with_name_Watershed_issued_in(int arg1) throws Throwable {
	        album = new Album("Watershed", "2008");
	 }

	 @Then("^Album Watershed saved!$")
	 public void album_Watershed_saved() throws Throwable {
		 app.getAlbumprepo().save(album);
	 }

	 @Given("^Artist with firstName Mikael and lastName Akerfeldt as guitar player for band Opeth$")
	 public void artist_with_firstName_Mikael_and_lastName_Akerfeldt_as_guitar_player_for_band_Opeth() throws Throwable {
		artist= new Artists();
		 artist.setFirstName("Mikael");
		 artist.setLastName("Akerfeldt");
		 artist.setBandName("Opeth");
		 artist.setInstrument("guitar");	     
	 }

	 @Then("^artist Mikael Akerfeldt saved!$")
	 public void artist_Mikael_Akerfeldt_saved() throws Throwable {
		 app.getArtistRepo().save(artist);
	 }

	 @Given("^Band with name Opeth that plays prog rock$")
	 public void band_with_name_Opeth_that_plays_prog_rock() throws Throwable {
		 band = new Band();
		 band.setBandName("Opeth");
		 	band.setGenre("prog rock");
	 }

	 @Then("^Band Opeth saved!$")
	 public void band_Opeth_saved() throws Throwable {
		 app.getRepository().save(band);
	 }
	 
}
