package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import hello.Album;
import hello.AlbumRepository;
import hello.Artists;
import hello.Band;
import hello.ProgrssiveRockRepository;
import hello.Track;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class UnitTestProgRockDummy {
	@Autowired
	private ProgrssiveRockRepository progrepo;
	@Autowired	
	private AlbumRepository albumrepo;
	@Autowired	
	private TrackRepository trackrepo;
	@Autowired
	private TourDateRepository tourRepo;
	@Autowired
	private ArtistRepo artistRepo;
	Band band;
	Album al;
	List<Album> albums;

	@Before
	public void initTests() {

		al = new Album();
		al.setAlbumName("watershed");
		Artists ar = new Artists();
		band = new Band();
		band.setBandName("Opeth");
		al.setBandName(band.getBandName());
		Track track;
		albums = new ArrayList<>();
		albums.add(al);

	}

	@Test
	public void testBandSearchShouldReturnNull() {
		Band b = new Band();
		b =progrepo.findByBandName("");
		assertEquals(null, b);
	}

	@Test
	public void testBandShouldReturnBand() {
		Band b = new Band();
		b=progrepo.findByBandName("Opeth");
		assertEquals("Opeth", b.getBandName());
		

	}

	@Test
	public void testOpethShouldHaveAlbumCalledStillLife() {
		
		Album album = new Album();
		album= albumrepo.findByAlbumName("Still life");
		Band bb = new Band();
		List<Album>albums = new ArrayList<>();
		albums=albumrepo.findByBandName("Opeth");
		assertTrue(albums.contains(album));
		//probleme de hashcode ici l'assertion echoue parce que les hashcode sont differents mais le contenu est le meme, ca a ete regle
		// en overridant la methode hashcode le test reussi maintenant
		
	}
	
	@Test
	public void testCheckIfMikaelisMemberOfOpeth() {
		List<Artists> artists = new ArrayList<>();
		artists = artistRepo.findByBandName("Opeth");
		Artists artist = new Artists();
		artist=artistRepo.findByLastName("Mikael");
		assertTrue(artists.contains(artist));
	}
	@Test
	public void testTrackForestOfOctoberShouldBeInOrchid() {
		List<Track> tracks = new ArrayList<>();
		tracks = trackrepo.findByAlbumName("orchid");
		Track track = new Track();
		track = trackrepo.findByTrackName("forest of october");
		assertTrue(tracks.contains(track));
	}
	
	@Test
	public void testShouldCheckIfKingCrimsonPlayedInMontreal() {
		TourDates tt = new TourDates();
		tt	 = tourRepo.findByCity("Montreal");
		Band bb = new Band();
		bb = progrepo.findByBandName("King Crimson");
		assertEquals(tt.getBandName(), bb.getBandName());
	}
	
	

}
